from functools import lru_cache

class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        # 10^6 < 2^20，所以置位个数不会超过 20，预计算到 32 位足够了
        primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}

        def count_with_prime_bits(n: int) -> int:
            if n <= 0: return 0
            s = bin(n)[2:]
            
            @lru_cache(None)
            def dp(i: int, cnt: int, is_limit: bool) -> int:
                if i == len(s):
                    return 1 if cnt in primes else 0
                
                res = 0
                up = int(s[i]) if is_limit else 1
                for d in range(up + 1):
                    res += dp(i + 1, cnt + d, is_limit and (d == up))
                return res
            
            return dp(0, 0, True)

        return count_with_prime_bits(right) - count_with_prime_bits(left - 1)