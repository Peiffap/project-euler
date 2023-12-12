# https://projecteuler.net/problem=78

import time
from functools import lru_cache

start = time.time()

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
    return p % 1000000 # no need to keep the rest of the number

i = 1
while True:
    p = pn(i) # count number of partitions
    if p % 1000000 == 0: # if divisible by 1000000, we're done
        print(i)
        break
    i += 1

end = time.time()
print(end - start)