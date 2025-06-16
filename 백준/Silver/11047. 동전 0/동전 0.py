N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]
sorted_coins = sorted(coins, reverse=True)
count = 0

for coin in sorted_coins:
    count += K // coin
    K %= coin
    
    if K == 0:
        break
        
print(count)