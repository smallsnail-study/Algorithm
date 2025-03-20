N = int(input())

words = [input() for _ in range(N)]

ans = 0

for word in words: # 단어들 리스트의 각 단어를 반복
    prev = word[0] # (현재문자와 비교할)앞의 문자
    before = [] # 현재문자 이전에 존재한 문자들을 저장할 리스트
    isGroup = True # 그룹단어 여부를 판별할 플래그

    for i in range(len(word)): # 각 단어의 문자들을 확인하는 반복문
        if prev != word[i]: # 앞문자가 현재문자와 다르다면
            before.append(prev) # before 리스트에 추가

        if word[i] in before: # 현재문자가 before 리스트에 이미 존재한다면
            isGroup = False # 그룹단어가 아님
            break # 반복문 종료

        prev = word[i] # 앞문자를 현재문자로 update

    if isGroup: # 그룹단어가 맞다면
        ans += 1 # 그룹문자 개수 update

print(ans)