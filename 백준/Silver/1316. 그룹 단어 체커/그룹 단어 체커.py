def is_group_word(word):
    prev = word[0]
    before = set()
    isGroup = True
    
    for i in range(len(word)):
        if prev != word[i]:
            before.add(prev)
        
        if word[i] in before:
            isGroup = False
        
        prev = word[i]
    
    return isGroup

N = int(input())

words = [input().strip() for _ in range(N)]

ans = 0

for word in words:
    if is_group_word(word):
        ans += 1

print(ans)