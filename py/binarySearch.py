from typing import List
import bisect

def binarySearch1(arr:List[int], target:int) -> int:
    l, r = 0, len(arr)
    while l < r:
        mid = (l + r) // 2
        if arr[mid] < target:
            l = mid + 1
        else:
            r = mid

    return l

def binarySearch2(arr:List[int], target:int) -> int:
    l, r = 0, len(arr)
    while l < r:
        mid = (l + r) // 2
        if arr[mid] > target:
            r = mid
        else:
            l = mid + 1

    return l


def test():
    test_cases = [
        ([1,2,3,6,6,6,7,8,12], 6),
        ([1,2,3,6,7,8,8,12], 8),
        ([1,2,3,6,7,8,12], -5),
        ([1,2,3,6,7,8,12], 17),
        ([1], 17),
        ([1,2], 17),
    ]

    for t in test_cases:
        arr, target = t
        print(binarySearch1(arr, target), bisect.bisect_left(arr, target))
        print(binarySearch2(arr, target), bisect.bisect_right(arr, target))

test()