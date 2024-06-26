import sys
n = int(sys.stdin.readline())

stack=[]
for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        stack.append(command[1])

    elif command[0] == 'pop':
        # 스택의 크기가 0이라면 -1을 출력한다.
        if len(stack) == 0:
            print(-1)
        # 스택의 크기가 0이 아니라면 스택의 최상단을 출력 한 후 삭제한다.
        else:
            print(stack.pop())

    elif command[0] == 'size':
        print(len(stack))

    elif command[0] == 'empty':
        # 스택이 비어있으면 1, 아니면 0을 출력한다.
        if len(stack) == 0:
            print(1)
        else: print(0)

    elif command[0]== 'top':
        # 스택에 들어 있는 정수가 없는 경우 -1 출력
        if len(stack) == 0:
            print(-1)
        # 스택의 가장 위에 있는 정수 출력
        else: print(stack[-1])