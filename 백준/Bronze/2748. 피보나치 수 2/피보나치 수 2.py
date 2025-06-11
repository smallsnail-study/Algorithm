n = int(input())
a, b = 0, 1

if n == 0:
    print(a)
else:
    for _ in range(2, n+1):
        a, b = b, a+b
    print(b)