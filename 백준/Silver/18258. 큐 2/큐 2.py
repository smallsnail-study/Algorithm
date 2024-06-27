import sys
# 파이썬에서 큐를 사용하기 위해 deque라는 라이브러리를 이용
from collections import deque
n = int(sys.stdin.readline().rstrip())
queue = deque([])

for i in range(n):
    command = sys.stdin.readline().rstrip().split()
    if command[0] == 'push':
        queue.append(command[1])
    elif command[0] == 'pop':
        # 큐에 들어있는 정수가 없는 경우 -1출력
        if not queue: print(-1)
        # 큐의 가장 앞에 있는 정수를 빼고, 그 수를 출력 popleft()함수 이용
        else: print(queue.popleft())
    elif command[0] == 'size':
        print(len(queue))
    elif command[0] == 'empty':
        if not queue: print(1)
        else: print(0)
    elif command[0] == 'front':
        if not queue: print(-1)
        else: print(queue[0])
    elif command[0] == 'back':
        if not queue: print(-1)
        else: print(queue[-1])