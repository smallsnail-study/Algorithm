n = int(input())

for i in range(n): # n은 총 출력 줄, i는 인덱스
    for j in range(i+1): # i번째 줄에 *을 i번 출력
        # print()는 줄바꿈이 기본값이므로 end=""을 통해 줄바꿈 방지
        print('*', end="")
    print()