from collections import deque

def direction_change(d, c): # 뱀의 방향 전환을 위한 함수
    if c == "L": # 뱀의 방향을 왼쪽으로 회전
        d = (d - 1) % 4
    else: # 뱀의 방향을 오른쪽으로 회전
        d = (d + 1) % 4
    return d

N = int(input()) # 보드크기
K = int(input()) # 사과 개수
board = [[0]*N for _ in range(N)] # 보드를 N*N 크기로 초기화
for _ in range(K):
    a, b = map(int, input().split()) # 사과 위치를 입력받고
    board[a-1][b-1] = 1 # 사과가 있는 곳은 board값을 1로 설정

L = int(input()) # 방향변환횟수
times = {} # 이동시간 X초
for i in range(L):
    X, C = input().split() #게임 시작 시간으로부터 X초 후에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다
    times[int(X)] = C

# 상,하,좌,우를 나타내기 위한 x축,y축
dy = [-1, 0, 1, 0] # -1은 위,1은 아래
dx = [0, 1, 0, -1] # 1은 우측, -1은 좌측

direction = 1 # 뱀의 현재 이동 방향, 최초이동인 오른쪽을 나타내기 위한 변수
time = 1 # 게임이 진행된 시간을 저장하기 위한 변수
y, x = 0, 0 # 뱀 머리의 현재 위치 저장을 위한 변수(최초 맨위맨좌측에 위치)
snake = deque([[y, x]]) # 뱀의 꼬리 위치를 큐의 형식으로 저장
board[y][x] = 2 # 뱀이 존재하는 곳은 board값을 2로 설정

while True:
    y, x = y + dy[direction], x +dx[direction] # 머리를 현재방향(direction)에 따라 이동시킨다.
    if 0<=y<N and 0<=x<N and board[y][x]!=2: # 0~N범위초과는 벽과부딪치는 것이고, board값이2라면 자기자신과 부딪치는것
        if board[y][x] != 1: # 게임 보드에서 이동한 칸에 사과(1)가 없다면
            delY, delX = snake.popleft() # 뱀의 꼬리 부분을 삭제, 이는 뱀이 한 칸 이동했음을 의미
            board[delY][delX] = 0 # 보드에서 뱀의 꼬리가 있던 위치를 빈 칸(0)으로 업데이트
        board[y][x] = 2 # 머리 위치는 보드값을 2로 바꾸어 뱀이 존재하는 것을 나타낸다.
        snake.append([y, x]) # 머리 위치도 큐에 넣는다.

        if time in times.keys(): # 현재 시간이 주어진 시간에 도달했다면,
            direction = direction_change(direction, times[time]) # 현재 방향을 times 딕셔너리에서 현재 시간에 해당하는 방향 변경 명령에 따라 변경
        time += 1

    else: break # 벽 또는 자기 자신의 몸과 부딪힌다면 while문에서 벗어난다.

print(time)