def solution(N, stages):
    # 스테이지별 도전자 수 (인덱스 사용을 위해 마지막스테이지(N+1)에 +1)
    challenger = [0] * (N + 2)
    
    for stage in stages:
        challenger[stage] += 1
    
    # 스테이지별 실패한 사용자 수
    fails = {} # key-value 딕셔너리
    # 총 사용자 수
    total = len(stages)
    
    # 각 스테이지를 순회하며 실패율 계산
    for i in range(1, N+1):
        if challenger[i] == 0: # 스테이지에 도전자가 없는 경우
            fails[i] = 0 # 실패율은 0
        else:
            fails[i] = challenger[i] / total
            total -= challenger[i]
        
    answer = sorted(fails, key=lambda x : fails[x], reverse=True)
    return answer