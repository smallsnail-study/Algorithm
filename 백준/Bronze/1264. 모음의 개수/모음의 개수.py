def count_vowels(s):
    vowels = 'aeiou'
    count = 0
    
    for char in s.lower():
        if char in vowels:
            count += 1
    
    return count

while True:
    str = input()
    if str == '#':
        break
    result = count_vowels(str)
    print(result)