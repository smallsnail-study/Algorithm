def solution(s):
    answer = 0
    n = len(s)
    
    # 1. 문자열을 회전하며 참조하는 반복문
    for i in range(n):
        stack = []
        for j in range(n):
            # 회전된 문자열의 현재 문자
            c = s[(i + j) % n]
            
            # 2. 여는 괄호는 스택에 추가
            if c in "([{":
                stack.append(c)
            else:
                # 3. 스택이 비어있거나 짝이 맞지 않으면 종료
                if not stack:
                    break
                
                # 4. 닫힌 괄호가 스택의 top과 짝이 맞는지 확인
                top = stack.pop()  # 스택의 top을 꺼냄
                
                # 짝이 맞는지 확인
                if c == ")":
                    if top == "(":
                        continue  # 짝이 맞으면 계속 진행
                elif c == "]":
                    if top == "[":
                        continue  # 짝이 맞으면 계속 진행
                elif c == "}":
                    if top == "{":
                        continue  # 짝이 맞으면 계속 진행
                
                # 짝이 맞지 않으면 종료
                break
        
        # 5. for문이 break 없이 끝났고 스택이 비어있다면 유효한 괄호 문자열
        else:
            if not stack:
                answer += 1
    return answer