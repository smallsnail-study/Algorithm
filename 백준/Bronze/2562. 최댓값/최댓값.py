nums = [int(input()) for _ in range(9)]
max_value = max(nums)
max_index = nums.index(max_value) + 1

print(max_value)
print(max_index)