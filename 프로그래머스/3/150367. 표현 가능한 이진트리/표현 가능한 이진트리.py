def solution(numbers):
    # 1개의 이진트리로 해당 수를 표현할 수 있는지 검증
    def valid(subtree : str) -> bool:
        # 규칙: 0인 노드 아래에 1이 없어야 함 -> True
        n = len(subtree)
        mid = n // 2 # 서브트리의 루트인덱스
        root = subtree[mid]
        left = subtree[:mid]
        right = subtree[mid+1:]

        # 종료조건: 루트가 0인데 자식이 1이 있으면
        if root == '0' and ('1' in left + right):
            return False

        # 리프노드인 경우
        if n == 1: 
            return True

        # 재귀
        return valid(left) and valid(right)
        
    answer = []

    for num in numbers:
        # 1. 주어진 수 2진수로 변환
        bnum = bin(num)[2:]

        # 2. 포화 이진트리 높이 찾기(len(bnum) <= 2^k-1)
        k = 1
        while (1<<k)-1 < len(bnum):
            k += 1

        # 3. 포화 이진트리의 전체 노드 수
        full_len = (1 << k) - 1

        # 4. 2진수 앞에 0 채우기(전체 노드 수 만큼)
        padded = bnum.zfill(full_len)

        # 5. 하나의 이진트리로 해당 수를 표현할 수 있는지 검증(1 or 0)
        answer.append(1 if valid(padded) else 0)
    return answer