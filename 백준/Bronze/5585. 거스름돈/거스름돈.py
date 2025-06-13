cost = int(input())
change = 1000 - cost

def min_coins(change):
    coins = [500, 100, 50, 10, 5, 1]
    count = 0
    
    rest = change
    while rest > 0:
        for coin in coins:
            if coin <= rest:
                rest -= coin
                count += 1
                break
    return count
    
print(min_coins(change))