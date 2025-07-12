# https://projecteuler.net/problem=76

import time
from functools import lru_cache

start = time.time()

n = 100 # number for which we want the partition

@lru_cache(maxsize=None) # cache to avoid duplicating function calls
def pn(n): # number of partitions of a nonnegative integer: p(n) = p(n - 1) + p(n - 2) - p(n - 5) - p(n - 7) + p(n - 12) + ... 
    if n == 0: # base case: one way of writing 0
        return 1
    p = 0 # number of partitions
    d1 = 1 # first index
    d2 = 1 # second index
    i = 0 # offset
    sign = 1 # to do the alternation in the sum
    while True:
        i += d2
        if i <= n:
            p += sign * pn(n - i)
        else:
            break
        d2 += 2
        i += d1
        if i <= n:
            p += sign * pn(n - i)
        else:
            break
        d1 += 1
        sign = -sign
    return p
        
print(pn(n) - 1) # remove 1 because we want the sum to have at least two terms, and one of the partitions only has one term (n)

end = time.time()
print(end - start)