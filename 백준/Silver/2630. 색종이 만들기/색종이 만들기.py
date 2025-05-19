# 쪼갠 문제 1: 주어진 영역이 모두 같은 색인지 판별
# matrix: 전체 2차원 배열
# x, y: 검사할 영역의 왼쪽 위 시작 행, 열 인덱스
# size: 검사할 영역의 크기 (가로/세로 길이)
# 반환값: 'white', 'blue', 'mixed' 중 하나
def is_uniform(matrix, x, y, size):
    # 영역의 왼쪽 위 칸 색깔을 기준 색으로 설정
    first_color = matrix[x][y]

    # 영역 내의 모든 칸을 순회하며 기준 색과 다른지 확인
    for i in range(x, x+size):
        for j in range(y, y+size):
            # 만약 기준 색과 다른 칸이 있다면 'mixed' 반환
            if matrix[i][j] != first_color:
                return 'mixed'
    
    # 영역 내의 모든 칸이 기준 색과 같다면, 그 색에 따라 'white' 또는 'blue' 반환
    if first_color == 0:
        return 'white'
    else:
        return 'blue'

# 주어진 영역 (x, y, size) 내에서 흰색/파란색 종이 개수를 세어 반환
def solve_paper(matrix, x, y, size):
    # 1. 현재 영역의 색상 상태 판별 (쪼갠 문제 1 활용)
    state = is_uniform(matrix, x, y, size)

    # 2. 베이스 케이스: 균일한 색이라면 해당 색 종이 개수 반환
    if state == 'white':
        return (1, 0) # (흰색 1개, 파란색 0개)
    elif state == 'blue':
        return (0, 1) # (흰색 0개, 파란색 1개)

    # 3. 재귀 케이스: 섞여 있다면 4등분하여 각 부분 재귀 호출 후 결과 합산
    half = size // 2
    # 네 사분면 재귀 호출
    w1, b1 = solve_paper(matrix, x, y, half) # 왼쪽위
    w2, b2 = solve_paper(matrix, x, y+half, half) # 오른쪽위
    w3, b3 = solve_paper(matrix, x+half, y, half) # 왼쪽아래
    w4, b4 = solve_paper(matrix, x+half, y+half, half) # 오른쪽아래

    # 네 사분면에서 얻은 흰색/파란색 개수를 각각 합산
    total_white = w1 + w2 + w3 + w4
    total_blue = b1 + b2 + b3 + b4

    # 합산된 결과 반환
    return (total_white, total_blue)

n = int(input())

matrix = []

for _ in range(n):
    row = list(map(int, input().split()))
    matrix.append(row)

# 최종 해결 함수 호출: 전체 종이 (0,0에서 시작, 크기 n)에 대해 실행
total_white_papers, total_blue_papers = solve_paper(matrix, 0, 0, n)

print(total_white_papers)
print(total_blue_papers)