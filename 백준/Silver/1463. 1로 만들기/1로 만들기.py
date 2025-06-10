N = int(input())
dp = [0] * (N+1)

for i in range(2, N+1):
    candidates = []
    if i % 3 == 0:
        candidates.append(dp[i // 3] + 1)
    if i % 2 == 0:
        candidates.append(dp[i // 2] + 1)
    candidates.append(dp[i - 1] + 1)
    
    dp[i] = min(candidates)

print(dp[N])