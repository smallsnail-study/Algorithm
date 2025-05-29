import sys

def is_vps(s):
    stack = []
    for char in s:
        if char == '(':
            stack.append('(')
        elif char == ')':
            if not stack:
                return "NO"
            stack.pop()

    return "YES" if not stack else "NO"

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    s = sys.stdin.readline().rstrip()
    print(is_vps(s))