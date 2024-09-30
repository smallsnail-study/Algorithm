def solution(N, stages):
    # 각 스테이지별 도전자 수를 저장하는 배열
    # N번째 스테이지를 클리어한 사용자 수가 N+1이므로 N+1을 인덱스로 사용하기 위해 N+2크기 배열로 설정
    challenger = [0] * (N + 2)
    
    # 각 stages 데이터의 값을 challenger의 인덱스로 사용
    for stage in stages:
        challenger[stage] += 1
    
    # 스테이지별 실패한 사용자 수 계산
    fails = {}
    total = len(stages) # 총 사용자 수
    
    # 각 스테이지를 순회하며, 실패율 계산
    for i in range(1, N+1):
        if challenger[i] == 0: # 도전자수가 0이면 실패율은 0
            fails[i] = 0
        else:
            # fails는 딕셔너리로 키는 i, 값은 실패율
            fails[i] = challenger[i] / total
            
            # 총 사용자 수에서 각 스테이지의 인원 수를 빼면 다음 스테이지에 도달한 사용자 수
            total -= challenger[i]
    
    # 값을 기준으로 실패율이 높은 스테이지부터 내림차순 정렬
    answer = sorted(fails, key=lambda x : fails[x], reverse=True)
    return answer