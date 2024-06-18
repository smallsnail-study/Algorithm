# 입력 및 초기화
N = int(input()) # 회의 수
meet = [tuple(map(int, input().split())) for _ in range(N)] # 회의 정보를 튜플 형태로 저장

# 종료 시간이 빠른 순으로, 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
meet.sort(key=lambda x: (x[1], x[0]))

# 사용할 수 있는 회의의 최대 개수와 마지막으로 선택한 회의의 종료 시간 초기화
answer = 0
endTime = 0

# 회의 정보를 하나씩 확인하면서 반복
for start, end in meet:
    # 현재 회의의 시작 시간이 마지막으로 선택한 회의의 종료 시간보다 크거나 같으면
    if endTime <= start:
        # 현재 회의를 선택하고, 선택한 회의의 종료 시간으로 endTime을 업데이트
        endTime = end
        # 회의 개수도 1증가시킨다
        answer += 1

print(answer)