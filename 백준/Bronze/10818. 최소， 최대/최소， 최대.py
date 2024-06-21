n = int(input())
# 여러 개의 수를 입력 받아야 하는 상황에서 하나의 변수만으로 모든 데이터를 저장하기 위해 배열을 사용
arr = list(map(int, input().split()))

max = arr[0] # 최댓값을 저장할 변수를 만들고, 배열의 첫 번째 값으로 초기화
min = arr[0] # 최소값을 저장할 변수를 만들고, 배열의 첫 번째 값으로 초기화

# 배열을 순회하며
for num in arr:

    # 현재 배열값 num이 max보다 크다면 max 값을 num으로 변경
    if num > max:
        max = num
    # 현재 배열값 num이 min보다 작다면 min 값을 num으로 변경
    if num < min:
        min = num

print(min, max)