# https://projecteuler.net/problem=203

import time
import math
import functools

start = time.time()


# generate list of primes up to n
def primes(n):
    p = []
    l = [True] * n  # is i prime?
    l[0] = False
    l[1] = False
    i = 2
    while i < n:  # while we aren't at n
        if l[i]:  # if i hasn't been crossed off, it is prime
            p.append(i)
            j = 2
            while i * j < n:
                l[i * j] = False  # multiples of i aren't prime
                j += 1
        i += 1
    return p


lim = 50


# compute factorials, using caching since we never exceed 50
@functools.lru_cache(maxsize=lim)
def fact(n):
    i = 1
    pr = 1
    while i <= n:
        pr *= i
        i += 1
    return pr


# compute the unique binomial coefficients in the first 51 rows
un = set()
for n in range(lim):
    for k in range(lim):
        un.add(fact(n) // ((fact(n - k)) * (fact(k))))


ps = primes(int(math.sqrt(max(un))))  # precompute primes

sfun = []
for n in un:
    sf = True  # assume number is squarefree
    for p in ps:  # try to find a prime such that p^2 divides n
        if p**2 > n:  # if p^2 is greater than n, no need to try more primes
            break
        if n % (p**2) == 0:  # does p^2 divide n?
            sf = False
            break
    if sf:  # only keep squarefree binomial coefficients
        sfun.append(n)

print(sum(sfun))  # print the sum of the squarefree binomial coefficients

end = time.time()
print(end - start)
