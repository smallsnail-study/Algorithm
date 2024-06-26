galho = input()
stack = []
answer = 0

for i in range(len(galho)):
    # '('를 만날 때마다 스택에 '('를 추가한다.
    if galho[i] == '(':
        stack.append(galho[i])

    # ')'를 만날 때
    else:
        # 스택의 최상단이 '('이라면, 스택의 크기만큼 총 개수에 추가한다.(레이저 ->현재 쇠막대기의 개수만큼 총 개수가 증가)
        if galho[i-1] == '(':
            stack.pop()
            answer += len(stack)

        # 스택의 최상단이 ')'라면 총 개수에 1을 추가한다.(쇠막대기가 종료 ->총 개수는 1이 증가)
        else:
            stack.pop()
            answer += 1

print(answer)