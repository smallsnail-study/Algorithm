import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())

queue = deque()

# 숫자가 클수록 위에 작을수록 아래에 배치
for i in range(n):
    queue.append(n - i)

while len(queue) > 1:
    # deque의 후단을 삭제
    queue.pop()
    # deque의 후단삭제 후 전단에 삽입
    queue.appendleft(queue.pop())

print(queue.popleft())