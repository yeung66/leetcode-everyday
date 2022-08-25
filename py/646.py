class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        i = j = 0
        n = len(target)
        print(target, arr)
        if n == 1:
            return target[0] == arr[0]

        if target[0] == arr[0]:
            return self.canBeEqual(target[1:], arr[1:])

        for j in range(1,n):
            if target[0] == arr[j]:
                newarr = arr[:j+1][::-1] + arr[j+1:]
                if self.canBeEqual(target[i+1:], newarr[1:]):
                    return True
            

                    
        return False

                
