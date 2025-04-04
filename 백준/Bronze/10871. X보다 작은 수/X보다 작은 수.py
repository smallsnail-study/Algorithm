N, X = map(int, input().split())

A = list(map(int, input().split()))

result = [ele for ele in A if ele < X]
print(*result)