class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        terms = []
        for i in range(0, len(s), 2 * k):
            terms.append(s[i:i+k][::-1])
            terms.append(s[i+k:i+2*k])

        return ''.join(terms)
