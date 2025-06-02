import sys
read_line = sys.stdin.readline

N = int(read_line())
cur = 666  # 제일 작은 어둠의 수
n_doom = 0 # 몇 번째 어둠의 수인지 체크

def is_doom(cur):
    return '666' in str(cur) # 문자열 안에 666이 포함되어 있는지 확인

while True:
    if is_doom(cur):
        n_doom += 1
    
    if n_doom == N:
        print(cur)
        break
    
    cur += 1