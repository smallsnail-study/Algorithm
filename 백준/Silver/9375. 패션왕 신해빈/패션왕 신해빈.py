testcase = int(input())

for i in range(testcase):
    # 의상종류 저장을 위한 map을 사용하기 위해 변수명={}을 사용
    map = {}
    answer = 1
    # 현재 테스트케이스에서 의상 수 n
    n = int(input())

    for j in range(n):
        # a = 의상의 이름, b = 의상 종류를 입력받는다.
        a, b = input().split()
        # 의상의 종류를 key로 하는 값이 map에 없다면,
        if not b in map:
            # key에 해당하는 value를 1로 설정해준다.(해당종류의 첫번째 의상 추가) map[key]=1
            map[b] = 1
        # 의상의 종류를 key로 하는 값이 map에 있다면,
        else:
            # key값에 해당하는 value를 1 증가시켜준다.(해당종류의 의상수 증가) map[key]+=1
            map[b] += 1

    # 의상 종류 순회
    for k in map.keys():
        # key에 해당하는 (value+1)값을 곱해준다. 의상의종류의 수+1(선택안함)
        answer = answer * (map[k] + 1)

    # 옷을 전부 입지 않은 값을 포함하므로 정답에서 -1을 뺀 값을 출력
    print(answer - 1)