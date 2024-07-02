class Node:
    def __init__(node, data, left_node, right_node):
        node.data = data
        node.left_node = left_node
        node.right_node = right_node

# 전위순회 중->왼->오
def pre_order(node):
    print(node.data, end='')
    if node.left_node != '.':
        pre_order(tree[node.left_node])
    if node.right_node != '.':
        pre_order(tree[node.right_node])

# 중위순회 왼->중->오
def in_order(node):
    if node.left_node != '.':
        in_order(tree[node.left_node])
    print(node.data, end='')
    if node.right_node != '.':
        in_order(tree[node.right_node])

# 후위순회 왼->오->중
def post_order(node):
    if node.left_node != '.':
        post_order(tree[node.left_node])
    if node.right_node != '.':
        post_order(tree[node.right_node])
    print(node.data, end='')

# 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
n = int(input())
tree = {}

# 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
for _ in range(n):
    data, left_node, right_node = input().split(' ')
    tree[data] = Node(data, left_node, right_node)

# 항상 A가 루트 노드가 된다.
# 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력
pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])