import first_step as FIRST
import sys

# 2단계의 입력, 출력, 스테이지 데이터 수정을 담당하는 핵심 함수
def start_play_game(stage_data, stage_number):
    print('Stage '+ str(stage_number + 1))
    display_stage(stage_data)
    
    while True: # 입력이 'q'가 읽힐 때 까지 반복
        user_input = get_user_command()
        
        for command in user_input:
            if is_valid_command(command):
                playerX, playerY = get_player_location(stage_data)
                operate_command(stage_data, command, playerX, playerY)
            else:
                display_stage(stage_data)
                print(command.upper()+ ':' +' (경고!) 해당 명령을 수행할 수 없습니다!')
        print()


# stage_data의 한 줄씩 읽어오면서 first_step.py의 convert_symbol_and_number() 변환함수를 재사용해서 스테이지를 사용자에게 보여준다
def display_stage(stage_data):
    print()
    for line in range(len(stage_data)):
        print( FIRST.convert_symbol_and_number(stage_data[ line ], False) )
    print()

# '3'으로 표시된 데이터가 플레이어의 위치므로 각 줄마다 읽으면서 '3'이 존재하면 (-1이 아니면) 좌표값을 리턴한다.
def get_player_location(stage_data):
    for x in range(len(stage_data)):
        y=stage_data[x].find('3')
        if y != -1:
            return x,y

# 명령 수행 후 결과를 출력한다.
def operate_command(stage_data, command, playerX, playerY):
    move_coordinates_dictionary = {'w' : (-1,0,'위로 이동합니다.'), 
                                   'a' : (0,-1,'왼쪽으로 이동합니다.'),
                                   's' : (1,0,'아래로 이동합니다.'), 
                                   'd' : (0,1,'오른쪽으로 이동합니다.') }

    is_valid = is_valid_location( stage_data, 
                                  playerX + move_coordinates_dictionary[ command ][0], 
                                  playerY + move_coordinates_dictionary[ command ][1] )
    if is_valid:
        modify_stage_data( stage_data, 
                           (playerX, playerY), 
                           (playerX + move_coordinates_dictionary[ command ][0],playerY + move_coordinates_dictionary[ command ][1]) )
        display_stage(stage_data)
        print(command.upper()+ ':' +move_coordinates_dictionary[ command ][2])

    else:
        display_stage(stage_data)
        print(command.upper()+ ':' +' (경고!) 해당 명령을 수행할 수 없습니다!')

# 유저로부터 올바른 커맨드가 입력되었는지 확인하는 함수
def is_valid_command(command):
    if command=='q': # 사용자가 Alt + F4 를 누른것과 동일하다고 생각하고 처리
        print('Bye~')
        sys.exit() # 프로그램 즉시 종료
    if (command =='w' or 
        command =='a' or 
        command =='s' or 
        command =='d') : return True
    return False

# valid한 데이터만 들어오므로 배열의 데이터를 바로 수정한다. 
# string형으로 저장된 데이터를 직접 인덱싱해 변경하는 것은 불가하므로 list형으로 변환후에 .join()함수로 재할당한다.
def modify_stage_data(stage_data, fromXY, toXY):
    temp_list=list( stage_data[fromXY[0]] )
    temp_list[fromXY[1]] = ' '
    stage_data[fromXY[0]] = ''.join(temp_list)

    temp_list=list( stage_data[toXY[0]] )
    temp_list[toXY[1]] = '3'
    stage_data[toXY[0]] = ''.join(temp_list)


# 플레이어가 가려는 위치가 유효한지 검사하는 함수
def is_valid_location(stage_data, toX, toY):
    if 0 <= toX < len(stage_data) and 0 <= toY < len(max(stage_data,key=len)) and stage_data[toX][toY] == ' ' :
        return True
    else:
        return False        

# 사용자의 커맨드를 입력받는 함수
def get_user_command():
    user_input = input('SOKOBAN> ')
    return user_input


if __name__=="__main__":
    main_map_data = FIRST.read_data_from_terminal()
    stage_number = 1 # 스테이지는 0번 인덱스부터 시작되므로 2번 스테이지를 의미함
    start_play_game( main_map_data[ stage_number ], stage_number )