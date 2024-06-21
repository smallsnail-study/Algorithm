# 입력 : 5개의 줄에 각 참가자가 얻은 4개의 평가 점수가 공백으로 구분되어 주어진다.
# 출력 : 우승자의 번호와 얻은 점수들

# 5명 각 참가자들의 점수를 2차원 배열 형태로 입력
human = [list(map(int, input().split())) for _ in range(5)]

# 각 점수의 합산을 담을 배열
totalScore = [0]*5
# 최고합산점수
maxScore = 0
# 우승자
winner = 0

for i in range(5):
    totalScore = sum(human[i])
    if totalScore > maxScore:
        maxScore = totalScore
        winner = i+1

print(winner, maxScore)