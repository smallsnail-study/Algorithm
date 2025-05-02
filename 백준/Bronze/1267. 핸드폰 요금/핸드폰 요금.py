n = int(input())

times = list(map(int, input().split()))

total_y = 0
total_m = 0

for time in times:
    cost_y = ((time // 30) + 1) * 10
    total_y += cost_y
    
    cost_m = ((time // 60) + 1) * 15
    total_m += cost_m
    
if total_y < total_m:
    print(f"Y {total_y}")
elif total_m < total_y:
    print(f"M {total_m}")
else:
    print(f"Y M {total_y}")