# https://projecteuler.net/problem=347

import time
import math

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


lim = 10000000
ps = primes(lim // 2)  # precomputed list of primes (no need to go higher)
maxes = set()  # set of maxes found
for i in range(len(ps) - 1):  # loop over the smallest prime p
    p = ps[i]
    #print(p)
    if p * p > lim:  # since p < q, if p * p > lim, so does p * q, and we don't need to increase p further
        break
    for j in range(i + 1, len(ps)):  # wlog (since we only consider unique maxes), p < q
        q = ps[j]
        m = 0
        qexp = 1  # exponent of q
        if p * q > lim:  # no need to check larger values of q, change p instead
            break
        while p * q**qexp <= lim:  # for each possible exponent of q (looping while the minimal product is below lim)
            pexp = int(math.log(lim / (q**qexp), p))  # compute the maximal exponent of p that still yields a valid product
            m = max(m, q**qexp * p**pexp)  # keep track of the maximal value among optima
            qexp += 1
        maxes.add(m)  # add the best option to the set, guaranteeing uniqueness

print(sum(maxes))  # sum the maxima


end = time.time()
print(end - start)
