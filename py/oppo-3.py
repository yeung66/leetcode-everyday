n = int(input())
nums = list(map(int,input().split()))
for _ in range(n-1):
    input()
    
nums.insert(0,0)
record = {}

for i in range(1,len(nums)):
    if nums[i] != i:
        record[nums[i]] = i

ans = 0
for i in range(1,len(nums)):
    if nums[i] != i:
        ans += 1
        idx = record[i]
        nums[idx] = nums[i]
        record[nums[i]] = idx

print(ans)