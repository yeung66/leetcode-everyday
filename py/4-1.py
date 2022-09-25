
def findMedian(arr1, arr2):
    m, n = len(arr1), len(arr2)
    if (m+n) % 2 == 0:
        return (findKth(arr1, arr2, (m+n) // 2 + 1) + findKth(arr1, arr2, (m+n) // 2)) / 2

    return findKth(arr1, arr2, (m+n) // 2 + 1)

def findKth(arr1, arr2, k):
    print(arr1, arr2, k)
    if len(arr1) == 0:
        return arr2[k]

    if len(arr2) == 0:
        return arr1[k]

    if k == 1:
        return min(arr1[0], arr2[0])

    m, n = len(arr1), len(arr2)
    mid = k // 2 -1
    l = min(m-1, mid)
    r = min(n-1, mid)
    if arr1[l] < arr2[r]:
        return findKth(arr1[l+1:], arr2, k -l-1)
    
    return findKth(arr1,arr2[r+1:], k - r-1)


a = [1,6,11,22,33]
b = [2,3,7,14,21,24,26]
c = [1,2,3,4]
    
print(findMedian(a,b), sorted(a+b))
print(findMedian(c,b), sorted(c+b))