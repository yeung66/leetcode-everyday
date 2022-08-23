n = int(input())

mapping = '0123456789abcdef'
def tran(num):
    return mapping[num]

def to_r(num: int, r: int) -> str:
    # num = abs(num)
    if num < 0:
        return '-1'
    ans = ''
    
    while num >= r:
        next, left = num // r, num % r
        ans = tran(left) + ans
        num = next

    if num > 0:
        ans = tran(num) + ans

    ans = ans if ans else '0'
    # print(r, ans)
    return ans

found = False
for r in range(2,17):
    num = to_r(n, r)
    if num == num[::-1]:
        print(r)
        found = True

if not found:
    print(-1)
    