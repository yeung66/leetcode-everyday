class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        pre = s[0]
        onelength, zerolength = (0, 1) if pre == '0' else (1, 0)
        one_cnt, zero_cnt = (0, 1) if pre == '0' else (1, 0)
        
        for i in s[1:]:
            if i == pre:
                if i == '1':
                    one_cnt += 1
                    if one_cnt > onelength:
                        onelength = one_cnt
                else:
                    zero_cnt += 1
                    if zero_cnt > zerolength:
                        zerolength = zero_cnt

            else:
                pre = i
                one_cnt, zero_cnt = (0, 1) if pre == '0' else (0, 1)

        print(onelength, zerolength)

        return onelength > zerolength