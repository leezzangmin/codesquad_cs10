# 저장하기 불러오기 기능

# 지도 데이터 변환하기 프로그램

# 되돌리기 기능 및 되돌리기 취소 기능 구현

import sys
import copy

class Sokoban_with_extra_feature:
    """추가기능이 포함된 소코반 게임 클래스"""

    #클래스 변수
    map_data = []       # 전체 스테이지의 정보를 담는 변수
    stage_data = []     # 하나의 스테이지 정보를 담는 변수
    stage_number = 0    # 스테이지 번호를 담는 변수
    number_of_turn = 0  # 유저의 움직임이 몇 번 있었는지 담는 변수
    save_slots=[0, 0, 0, 0, 0]  # 세이브 슬롯 변수
    stage_move_stack = []       # 스테이지 정보를 턴별로 저장하는 스택
    stage_move_cancle_stack = [] # 스테이지 되돌리기 기능을 사용하면 저장되는 스택
    

    def __init__(self):
        self.map_data = self.read_data_from_encrypted_txtfile()
        self.stage_data = copy.deepcopy( self.map_data[ self.stage_number ] )

        print('Stage '+ str( self.stage_number + 1 ))
        self.display_stage()
        while True: # 입력이 'q'가 읽힐 때 까지, 스테이지를 모두 클리어할 때 까지 반복
            self.start_play_game()
        

    #  데이터를 기호나 숫자로 '한 줄씩' 바꾸는 함수
    def convert_symbol_and_number(self,map_data_line, is_symbol):
        line_data='' # 변환된 한줄짜리 맵 데이터를 담을 임시 변수
        
        # 정방향 변환 (기호를 숫자로변환)
        if is_symbol: 
            for character in range(len(map_data_line)):
                line_data += self.check_chr(map_data_line[ character ])

        # 역방향 변환 (숫자를 기호로변환)
        else:         
            for character in range(len(map_data_line)):
                line_data += self.check_chr_reverse(map_data_line[ character ])

        return line_data


    # 기호를 확인해서 맞는 숫자값을 리턴해주는 함수
    def check_chr(self, character):
        if character=='#':
            return '0'
        elif character=='O':
            return '1'
        elif character=='o':
            return '2'
        elif character=='P':
            return '3'
        elif character=='=':
            return '4'
        elif character=='0':
            return '6'
        else:
            return character

    # 숫자를 확인해서 맞는 기호를 리턴해주는 함수 check_chr의 반대되는 일을 수행
    def check_chr_reverse(self, character):
        if character=='0':
            return '#'
        elif character=='1':
            return 'O'
        elif character=='2':
            return 'o'
        elif character=='3':
            return 'P'
        elif character=='4':
            return '='
        elif character=='5': # 구멍과 플레이어가 겹친 상태
            return 'P'
        elif character=='6': # 구멍과 공이 겹친 상태
            return '0'
        else:
            return character

    # 사용자의 위치를 리턴하는 함수
    def get_player_location(self):
        for x in range( len( self.stage_data ) ):
            y = self.stage_data[x].find('3') # 보통 플레이어의 상태
            if y != -1:
                return x, y
            y = self.stage_data[x].find('5') # 플레이어가 구멍과 겹쳐있는 상태
            if y != -1:
                return x, y

    # 게임을 플레이하게 해주는 함수
    def start_play_game(self):
        user_input = self.get_user_command()
        
        for command in user_input:
            if self.is_valid_command( command ):
                playerX, playerY = self.get_player_location()
                self.operate_command( command, playerX, playerY )
            else:
                self.display_stage()

            if self.is_clear(): # 클리어 상태라면
                self.show_and_clear_stage()
        print()
    
    # stage_data의 한 줄씩 읽어오면서 first_step.py의 convert_symbol_and_number() 변환함수를 재사용해서 스테이지를 사용자에게 보여준다
    def display_stage(self): #stage_data):
        print()
        for line in range(len( self.stage_data )):
            print( self.convert_symbol_and_number( self.stage_data[ line ], False) )
        print()


    # 사용자의 명령을 수행하는 함수
    def operate_command(self, command, playerX, playerY):
        move_coordinates_dictionary = {'w' : (-1,0), 
                                       'a' : (0,-1),
                                       's' : (1,0), 
                                       'd' : (0,1) }

        if self.is_valid_location( (playerX, playerY), move_coordinates_dictionary[ command ]):
            self.stage_move_stack.append( copy.deepcopy ( self.stage_data ))
            self.modify_stage_data( (playerX, playerY), move_coordinates_dictionary[ command ])
            self.number_of_turn += 1 # 턴수 증가
        self.display_stage()


    # valid한 데이터만 들어오므로 교착상태(ex.공 두개를 동시에 미는 경우)가 아니라면 배열의 데이터를 바로 수정한다. 
    # string형으로 저장된 데이터를 직접 인덱싱해 변경하는 것은 불가하므로 list형으로 변환후에 .join()함수로 재할당한다.
    def modify_stage_data(self, fromXY, direction):
        toXY = ( fromXY[0] + direction[0], fromXY[1] + direction[1] )
        temp_list = list( self.stage_data[fromXY[0]] )
        if temp_list[fromXY[1]] == '5': temp_list[fromXY[1]] = '1'# 전에 플레이어가 있던 곳이 구멍과 겹쳐져 있던 상태면, '1' 을 다시 넣어줌
        else: temp_list[fromXY[1]] = ' '
        self.stage_data[fromXY[0]] = ''.join(temp_list)
        temp_list = list( self.stage_data[toXY[0]] )
        if temp_list[toXY[1]] == '1': # 플레이어가 갈 곳에 구멍이 있으면, 겹친상태인 '5'를 넣어줌
            temp_list[toXY[1]] = '5'
        elif temp_list[toXY[1]] == '2':
            if self.stage_data[ toXY[0] + direction[0] ][ toXY[1] + direction[1] ] == '1': # 공을 미는데 그 앞이 구멍이라면
                self.hardcoded_modify_stage_data(temp_list, toXY, direction, '3', '6');return
            elif self.stage_data[ toXY[0] + direction[0] ][ toXY[1] + direction[1] ] == ' ': #공을 미려는 곳이 빈공간이라면
                self.hardcoded_modify_stage_data(temp_list, toXY, direction, '3', '2');return
        elif temp_list[toXY[1]] == '6':
            if self.stage_data[ toXY[0] + direction[0] ][ toXY[1] + direction[1] ] == '1': # 공과 구멍이 겹친 지점을 미는데 그 앞이 구멍이라면
                self.hardcoded_modify_stage_data(temp_list, toXY, direction, '5', '6');return
            elif self.stage_data[ toXY[0] + direction[0] ][ toXY[1] + direction[1] ] == ' ': # 공과 구멍이 겹친 지점을 미려는 곳이 빈공간이라면
                self.hardcoded_modify_stage_data(temp_list, toXY, direction, '5', '2');return
        else: temp_list[toXY[1]] = '3'
        self.stage_data[toXY[0]] = ''.join(temp_list)

    # modify_stage_data() 함수에서 반복되는 구문을 함수로 빼서 가독성 상승
    def hardcoded_modify_stage_data(self,temp_list, toXY, direction, modify_value_1, modify_value_2):
        temp_list[ toXY[1] ] = modify_value_1
        self.stage_data[ toXY[0] ] = ''.join(temp_list)
        temp_list = list( self.stage_data[ toXY[0] + direction[0] ] )
        temp_list[ toXY[1] + direction[1] ] = modify_value_2
        self.stage_data[ toXY[0] + direction[0] ] = ''.join(temp_list)
        return


    # 유저로부터 올바른 커맨드가 입력되었는지 확인하는 함수
    def is_valid_command(self,command):
        if command=='q': # 사용자가 Alt + F4 를 누른것과 동일하다고 생각하고 처리
            print('Bye~')
            sys.exit() # 프로그램 즉시 종료

        if command=='r':  # 스테이지 초기화 함수 실행
            self.reset_stage()

            return False
        if command=='u':           # 되돌리기 명령
            self.undo_command()                
            return False

        if command=='U':           # 되돌리기 취소 명령
            self.redo_command()
            return False

        if (command =='w' or 
            command =='a' or 
            command =='s' or 
            command =='d') : return True
        else: print('유효하지 않은 입력 :', command)
        return False

    # 유저의 커맨드를 한턴 되돌리는 함수
    def undo_command(self):
        if len(self.stage_move_stack) != 0:
            self.stage_move_cancle_stack.append( copy.deepcopy( self.stage_data ) )
            self.stage_data = self.stage_move_stack.pop()
            self.number_of_turn -= 1
        else:
            print('되돌릴 명령이 없습니다!')

    # 유저가 되돌린 커맨드를 되돌리는 함수
    def redo_command(self):
        if len(self.stage_move_cancle_stack) != 0:
            self.stage_data = self.stage_move_cancle_stack.pop()
            self.number_of_turn += 1
        else:
            print('취소할 되돌리기 명령이 없습니다!')

    # 플레이어가 가려는 위치가 유효한지 검사하는 함수
    def is_valid_location(self, fromXY, direction):
        toX = fromXY[0] + direction[0]; toY = fromXY[1] + direction[1]
        if 0 <= toX < len( self.stage_data ) and 0 <= toY < len( max( self.stage_data, key = len ) ):
            if self.stage_data[toX][toY] == ' ' or self.stage_data[toX][toY] == '1': #가려는 곳이 빈 공간이거나 구멍이면
                return True
            elif self.stage_data[toX][toY] == '0':
                return False
                # 가려는 곳에 공이 있고 그 앞에 장애물이 있으면
            elif ( self.stage_data[toX][toY] == '2' or self.stage_data[toX][toY] == '6' ) and (self.stage_data[ toX + direction[0] ][ toY + direction[1] ] == '6' or self.stage_data[ toX + direction[0] ][ toY + direction[1] ] == '2' or self.stage_data[ toX + direction[0] ][ toY + direction[1] ] == '0'): # 미려는 대상에 공이 포함되어 있다면
                return False
            return True
        return False        


    # 사용자의 커맨드를 입력받는 함수
    def get_user_command(self):
        user_input = input('SOKOBAN> ')
        return user_input
    
    # 스테이지를 초기상태로 되돌리는 함수
    def reset_stage(self):
        self.stage_data = copy.deepcopy( self.map_data[ self.stage_number ] )
        self.number_of_turn = 0
        self.stage_move_stack = []
        self.stage_move_cancle_stack = []

    # 스테이지가 클리어 상태에 도달했는지 확인하는 함수
    def is_clear(self):
        for line in range( len( self.stage_data ) ):
            if self.stage_data[line].find('1') != -1: # 'O'가 존재하면 return False
                return False
            if self.stage_data[line].find('5') != -1: # 'P'와 'O'가 겹쳐있으면 return False
                return False
        return True

    # 게임 결과(턴수, 라운드)를 보여주고 다음 스테이지를 준비하는 함수
    def show_and_clear_stage(self):
        self.stage_number += 1 # 다음 스테이지로 넘어가기 위한 클래스 변수
        print('빠밤! Stage ',self.stage_number, ' 클리어!\n턴수:', self.number_of_turn,'\n')

        if self.stage_number == len( self.map_data ):   # 스테이지 번호가 맵 전체 길이와 같으면 전체 클리어
            print('전체 게임을 클리어하셨습니다!\n축하드립니다!')
            sys.exit()
        else:
            self.reset_stage()
            print('Stage '+ str( self.stage_number + 1 ))
            self.display_stage()
            
    # s 커맨드가 들어왔을때 진행상황을 저장해주는 함수
    def game_save(self):
        pass
    # l 커맨드가 들어왔을 때 진행상황을 불러오는 함수
    def game_load(self):
        pass
    
    # 일반 txt파일을 암호화된 txt파일로 변환하는 함수
    # '일반 텍스트 에디터로 읽을 수 없는' 이라는 요구사항이 모호해서 일반 사용자가 임의로 해석할 수 없는 수준의 암호화를 하는 것으로 이해하고 함수를 작성했다.
    def encrypt_txt_file(self):
        txt_file = open('map.txt', 'r')
        enc_txt_file = open('enc_map.txt', 'w')
        for line in txt_file.readlines():
            enc_line=''
            for character in line:
                enc_line += chr( ord(character) + 3 ) # 글자마다 아스키코드를 3씩 증가시킴
            enc_txt_file.writelines(enc_line)

        txt_file.close()
        enc_txt_file.close()


    # 암호화된 문장을 한줄씩 복호화화는 함수
    def decode_encrypted_txt_file(self, enc_line):
        decoded_line = ''
        for character in enc_line:
            decoded_line += chr( ord(character) - 3 ) # 글자마다 아스키코드를 다시 3씩 빼서 평문으로 만듦

        return decoded_line

    # enc_txt파일을 열어서 복호화시키고 map_data 변수에 저장 후 리턴해줌
    def read_data_from_encrypted_txtfile(self):
        txt_file = open("enc_map.txt", 'r')
        map_data, stage_data = [], []

        input_data = self.decode_encrypted_txt_file( txt_file.readline().rstrip() )
        while input_data != '':        # 입력이 공백으로 주어질 때 까지 계속 입력받음
            if input_data[0] == 'S':   # 읽어온 문자열의 첫 글자가 'S'면 스테이지 번호를 나타내므로 스킵하고 다음줄 읽음
                input_data = self.decode_encrypted_txt_file( txt_file.readline().rstrip() )
                stage_data.append( self.convert_symbol_and_number(input_data, True) )
            elif input_data[0] == '=': # 읽어온 문자열의 첫 글자가 '=' 이면 스테이지 구분자로 사용되므로 스킵하고 다음 스테이지 읽음
                map_data.append(stage_data)
                input_data = self.decode_encrypted_txt_file( txt_file.readline().rstrip() )
                stage_data=[]
            else:
                stage_data.append( self.convert_symbol_and_number(input_data, True) )
            input_data = self.decode_encrypted_txt_file( txt_file.readline().rstrip() )
        txt_file.close()
        map_data.append(stage_data)
        return map_data


if __name__=="__main__":
    sokoban_game = Sokoban_with_extra_feature()