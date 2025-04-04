def count_vowels(s):
    vowels = 'aeiou'
    return sum(1 for char in s.lower() if char in vowels)

while True:
    str = input()
    if str == '#':
        break
    result = count_vowels(str)
    print(result)