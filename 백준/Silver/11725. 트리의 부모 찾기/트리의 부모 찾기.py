import sys
sys.setrecursionlimit(10**6) # 재귀 한계를 1,000,000까지 늘림

N = int(input())
edges = [list(map(int, input().split())) for _ in range(N-1)]
tree = { i: [] for i in range(1, N+1) }

for edge in edges:
    s, e = edge # start, end
    # 양방향 저장
    tree[s].append(e)
    tree[e].append(s)

parents = [0] * (N+1)
def traverse(cur, parent):
    parents[cur] = parent
    
    for next in tree[cur]:
        if next == parent:
            continue
        
        traverse(next, cur)

traverse(1, 0)        
print(*parents[2:], sep="\n")