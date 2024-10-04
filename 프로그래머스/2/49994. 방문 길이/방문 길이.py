# 좌표평면을 벗어나는지 체크하는 함수
def is_valid_move(nx, ny):
    return 0 <= nx < 11 and 0 <= ny < 11

# 명령어를 통해 다음 좌표 결정
def update_location(x, y, dir):
    if dir == 'U':
        nx, ny = x, y+1
    elif dir == 'D':
        nx, ny = x, y-1
    elif dir == 'R':
        nx, ny = x+1, y
    elif dir == 'L':
        nx, ny = x-1, y
    return nx, ny

def solution(dirs):
    x, y = 5, 5
    answer = set() # 중복 좌표는 1개로 처리하기 위해 set
    
    # 명령어 순서대로 순회
    for dir in dirs:
        nx, ny = update_location(x, y, dir)
        if not is_valid_move(nx, ny): # 좌표 평면을 벗어난다면 반영x
            continue
    
        # A->B, B->A를 같은 경로로 취급하므로 둘 다 추가하고 최종 이동길이를 /2
        answer.add((x, y, nx, ny))
        answer.add ((nx, ny, x, y))
        x, y = nx, ny # 좌표 이동 후 업데이트

    return len(answer)/2