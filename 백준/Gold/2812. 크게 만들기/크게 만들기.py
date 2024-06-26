# n 자리 숫자가 주어질 때, k개를 지워서 얻는 가장 큰 수

# 첫째 줄에 N과 K가 주어진다.
n, k = map(int, input().split())
# 둘째 줄에 N자리 숫자가 주어진다.
number = list(input())

# 가장 큰 수를 스택으로 저장할 변수
answer = []
cnt = k

# number 배열을 순회
for num in number:
    # 1. answer 스택이 비어 있지 않고,
    # 2. 지울 수 있는 횟수 k가 남아있고,
    # 3. answer의 마지막 값이 num보다 작다면
    # answer의 마지막 값을 지운다.
    while answer and cnt > 0 and answer[-1] < num:
        del answer[-1]
        cnt -= 1

    answer.append(num)

print(''.join(answer[:n-k]))