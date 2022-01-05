# sys 모듈의 stdin.readline 함수로 입력 성능 증가
import sys

# 유저로부터 맵 데이터를 입력받는 함수
def read_data_from_terminal():
    map_data = []
    stage_data=[]

    input_data = sys.stdin.readline().rstrip()
    while input_data != '':        # 입력이 공백으로 주어질 때 까지 계속 입력받음
        if input_data[0] == 'S':   # 읽어온 문자열의 첫 글자가 S면 스테이지 번호를 나타내므로 스킵하고 다음줄 읽음
            input_data = sys.stdin.readline().rstrip()
            stage_data.append( convert_symbol_and_number(input_data, True) )
        elif input_data[0] == '=': # 읽어온 문자열의 첫 글자가 = 이면 스테이지 구분자로 사용되므로 스킵하고 다음 스테이지 읽음
            map_data.append(stage_data)
            input_data = sys.stdin.readline().rstrip()
            stage_data=[]
        else:
            stage_data.append( convert_symbol_and_number(input_data, True) )
        input_data = sys.stdin.readline().rstrip()

    map_data.append(stage_data)
    return map_data

#  데이터를 기호나 숫자로 '한 줄씩' 바꾸는 함수
def convert_symbol_and_number(map_data_line, is_symbol):
    line_data='' # 변한된 한줄짜리 맵 데이터를 담을 임시 변수
    
    # 정방향 변환 (기호를 숫자로변환)
    if is_symbol: 
        for character in range(len(map_data_line)):
            line_data += check_chr(map_data_line[character])

    # 역방향 변환 (숫자를 기호로변환)
    else:         
        for character in range(len(map_data_line)):
            line_data += check_chr_reverse(map_data_line[character])

    return line_data


# 기호를 확인해서 맞는 숫자값을 리턴해주는 함수
def check_chr(character):
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
    else:
        return character

# 숫자를 확인해서 맞는 기호를 리턴해주는 함수 check_chr의 반대되는 일을 수행
def check_chr_reverse(character):
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
    else:
        return character

# 스테이지 정보를 출력하는 함수
def print_map(map_data):
    for stage_index in range(len(map_data)): # 스테이지 한개 단위로 loop 반복
        number_of_balls, number_of_holes, location_of_player = 0, 0, ()
        print('Stage', stage_index + 1, '\n')

        for line_index in range(len(map_data[ stage_index ])):
            print( convert_symbol_and_number(map_data[ stage_index ][ line_index ], False) )
            ballnum, holenum, location = calculate_map(map_data[ stage_index ][ line_index ], line_index )
            number_of_balls += ballnum; number_of_holes += holenum; 
            if location: location_of_player = location

        display_stage_feature( len(max(map_data[ stage_index ],key=len)), # 가로크기
                               len(map_data[ stage_index ]),              # 세로크기
                               number_of_holes,               # 구멍의 수
                               number_of_balls,               # 공의 수
                               location_of_player )           #플레이어 위치



# 스테이지의 오브젝트의 정보를 매개변수로 받아 출력하는 함수
def display_stage_feature(map_col, map_row, number_of_holes, number_of_balls, location_of_player):
    print('\n가로크기:', map_col)
    print('세로크기:', map_row)
    print('구멍의 수:', number_of_holes)
    print('공의 수:', number_of_balls)
    print('플레이어 위치:', location_of_player, '\n')

# 맵에 있는 오브젝트를 파악해서 그 갯수나 위치를 튜플형태로 반환하는 함수
def calculate_map(map_data_line, row):
    hole_count,ball_count = 0, 0
    location_of_player = ()

    for i in range(len(map_data_line)):
        if map_data_line[i] == '1':
            hole_count += 1
        elif map_data_line[i] == '2':
            ball_count += 1
        elif map_data_line[i] == '3':
            location_of_player = i + 1

    return ( ball_count, 
             hole_count,
             (row + 1, location_of_player) if location_of_player != () else False )



if __name__=="__main__":
    main_map_data = read_data_from_terminal()
    print_map(main_map_data)