import sys
read_line = sys.stdin.readline

n = int(read_line())
nums = list(map(int, read_line().split()))

sorted_unique_nums = sorted(set(nums))

num_to_idx = {}
for idx, num in enumerate(sorted_unique_nums):
    num_to_idx[num] = idx

compressed_nums = []
for num in nums:
    compressed_nums.append(num_to_idx[num])

print(*compressed_nums)