x = int(input())

cnt = 0
chars = 'abcdefghijklmnopqrstuvwxyz'
s = 'a' * x
find = chars[cnt] * 2
while find in s:
    cnt += 1
    s = s.replace(find, chars[cnt])
    find = chars[cnt] * 2

print(s)

