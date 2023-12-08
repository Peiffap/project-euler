# https://projecteuler.net/problem=800

import time
import numpy as np
import scipy.special as ss
import decimal

start = time.time()

# list of primes
def primes(n, prime_list=False):
    p = []
    l = [True] * n
    l[0] = False
    l[1] = False
    i = 2
    while i < n:
        if l[i]:
            if prime_list:
                p.append(i)
            j = 2
            while i * j < n:
                l[i * j] = False
                j += 1
        i += 1
    if prime_list:
        return l, p
    else:
        return l

# if p^q q^p < 800800^800800, then q ln p + p ln q < 800800 ln 800800

_, ps = primes(16000000, True) # generate primes up to an n such that 2^n n^2 > 800800^800800
primelogs = np.emath.log(ps) # precompute logs
l800800 = 800800 * np.emath.log(800800)

cnt = 0
j = len(ps) - 1
lastj = j # keep track of the last maximal q satisfying p^q q^p < 800800^800800
for i, p in enumerate(ps): # iterate over p
    q = ps[j]
    j = lastj
    while j > i and p * primelogs[j] + q * primelogs[i] > l800800: # as long as we are too big, reduce q
        j -= 1
        q = ps[j]
    #print(p, q, i, j)
    if j <= i: # if no q > p was found satisfying p^q q^p < 800800^800800, we're done
        break
    cnt += j - i # else, update count and last seen j
    lastj = j    
    
print(cnt)

end = time.time()
print(end - start)