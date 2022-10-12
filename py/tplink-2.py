

def findMedianIndex(arr):
    n = len(arr)
    sums = sum(arr)

    leftSum = 0
    for i, num in enumerate(arr):
        if i == 0 or i == n - 1:
            leftSum += num
            continue

        if leftSum * 2 + num == sums:
            return i

        leftSum += num

    return -1

        
a = [1]
print(findMedianIndex(a))