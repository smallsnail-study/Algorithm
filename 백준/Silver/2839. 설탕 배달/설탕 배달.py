n = int(input())
count_3kg = 0

while (n % 5) != 0 and n >= 0:
    n -= 3
    count_3kg += 1

if n < 0:
    print(-1)
else:
    print(n // 5 + count_3kg)