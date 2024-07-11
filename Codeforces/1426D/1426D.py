n = int(input())
# 배열 a
a = list(map(int, input().split()))

# 누적합을 저장하기 위한 배열 생성
prefix_sum = [0]*200001

# map은 누적합을 저장하여 중복된 누적합을 빠르게 찾기 위해 사용
map = {}

# 연속된 부분 배열의 합이 0이 되는 경우의 수를 저장하기 위한 변수
answer = 0

# 연속된 배열의 합이 0일 때를 확인하기 위해 1로 초기화
map[0] = 1
for i in range(n):
    # 현재 요소를 누적합 배열에 저장
    prefix_sum[i] = a[i]

    # 첫 번째 요소가 아닌 경우
    if i != 0:
        # 누적합 = 이전 합 + 현재 합
        prefix_sum[i] += prefix_sum[i-1]

    # 현재 누적합이 해시맵에 존재한다면,
    if prefix_sum[i] in map:
        #  정답의 개수를 1증가하고,
        answer += 1
        #  map자료구조를 초기화해준다.
        map.clear()
        # 이후 무한을 삽입한 다음,
        # 누적합부터 다시 수를 삽입해야 하는 연속된 배열의 합이 0일 때를 확인하기 위해
        # map[prefix_sum[i-1]]=1로 값을 설정해준다.
        map[prefix_sum[i-1]] = 1

    # 현재 누적합을 해시맵에 저장
    map[prefix_sum[i]] = 1

print(answer)