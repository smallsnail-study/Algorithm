# LinkedList에서 사용할 노드를 정의한다.
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# LinkedList의 처음 부분을 정의한다.
class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    # LinkedList의 데이터를 삽입한다.
    def insert(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(value)

    # LinkedList의 해당 index값을 가져온다.
    def get_node(self, index):
        node = self.head
        count = 0
        while count < index:
            count += 1
            node = node.next

        return node

    # LinkedList의 해당 index값을 삭제한다.
    def delete_Node(self, index):
        if index == 0:
            del_node = self.head.data
            self.head = self.head.next
            return del_node
        node = self.get_node(index - 1)
        del_node = node.next.data
        node.next = node.next.next
        return del_node

N, K = map(int, input().split())
# LinkedList 자료구조에 첫 값을 1로 넣어준다.
Link = LinkedList(1)

# 2~n 까지의 수들을 n에 넣어준다.
for i in range(2, N + 1):
    Link.insert(i)
# 정답을 기록하기 위한 asswer 변수를 생성한다.
answer = []
# idx = k-1(초기 위치를 k-1)로 설정핟나.
idx = K - 1

# LinkedList가 비어 있지 않다면 무한 반복한다.
while Link.head is not None:
    # idx %= N(남이 있는 사람 수로 나눈 나머지 값)으로 설정한다.
    idx %= N
    # answer 에 LinkedList의 idx번째 노드의 값을 넣고 LinkedList의 idx번째 노드를 삭제하단.
    answer.append(Link.delete_Node(idx))
    # idx += (k-1)로 설정한다.(오른쪽으로 3번 이동)
    idx += (K - 1)
    # 남아있는 사람의 수 -= 1이다.
    N -= 1

print('<', end='')
for i in range(len(answer) -1):
    print(answer[i], end=', ')
print(answer[len(answer) -1], end='')
print('>')