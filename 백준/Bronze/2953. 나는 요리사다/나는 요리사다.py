# 입력 : 5개의 줄에 각 참가자가 얻은 4개의 평가 점수가 공백으로 구분되어 주어진다.
# 출력 : 우승자의 번호와 얻은 점수들

# 5명 각 참가자들의 점수를 2차원 배열 형태로 입력
human = [list(map(int, input().split())) for _ in range(5)]

# 다른 사람이 평가해 준 점수의 합을 저장하기 위한 배열을 생성
# 5개의 0으로 초기화된 리스트 [0, 0, 0, 0, 0]
humanScore = [0]*5
# print(humanScore)

# 최대 점수를 저장하기 위한 변수
score = 0

for i in range(5): # 5개의 줄을 반복하면서
    sum = 0 # 점수의 합계를 저장하기 위한 변수
    for j in range(4): # 각 참가자마다 4번의 평가를 받았으므로 4번 순회하며
        sum += human[i][j] # 각 점수들의 합계를 저장
    humanScore[i] = sum # 해당 참가자의 점수의 합계(sum)를 저장
    score = max(score, sum) # 기존 저장되어 있는 점수와 합산점수를 비교하여 최댓값을 저장

for i in range(5):
    # 참가자의 총 점수가 최대점수(score)라면
    if humanScore[i] == score:
        # 우승자의번호(i+1)과 점수(score)출력하고 반복문 탈출
        print(i+1, score)
        break