def sum(a, b):
    return a+b
def sub(a, b):
    return a-b
def mul(a, b):
    return a*b
def div(a, b):
    return int(a/b)
def mod(a, b):
    return a%b

a, b = map(int,input().split())
print(sum(a,b))
print(sub(a,b))
print(mul(a,b))
print(div(a,b))
print(mod(a,b))