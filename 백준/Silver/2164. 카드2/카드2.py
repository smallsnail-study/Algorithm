import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())

queue = deque()

# 큐의 맨 뒤에 1부터 n까지의 숫자를 삽입
for i in range(n):
    queue.append(i + 1)

# 큐의 크기가 1보다 클 때, 큐의 가장 앞을 삭제, 
# 그리고 다시 가장 앞을 가장 뒤에 삽입 반복
while len(queue) > 1:
    queue.popleft()
    queue.append(queue.popleft())

print(queue.pop())