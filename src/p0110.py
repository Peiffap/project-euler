# https://projecteuler.net/problem=110

# solution based on the following observation
# if 1/x + 1/y = 1/n then ny + nx = xy
# <=> n^2 + nx + ny - xy = n^2
# <=> (n - x)(n - y) = n^2
# this means that any pair of the form (x, y) = (n + a, n + b) is a solution if ab = n^2
# to find the number of solutions, we need to find the number of unique ways one can write n^2 as a product
# we know by the fundamental theorem of arithmetic that n = p_1^{a_1} * ... * p_i^{a_i}
# hence n^2 = p_1^{2a_1} * ... * p_i^{2a_i}
# the number of valid pairs is then 1 + (2a_1 + 1) * ... * (2a_1 + 1) / 2, the number of unique partitions of this set
# since we double count (wlog, a <= b), we have to divide by two
# but we must add 1 since a = b = n is only counted once

import time
from itertools import product

start = time.time()

# compute how many unique ways there are to write n^2 = p_1^(2d_1) * ... * p_i^(2d_i) as a product ab with a <= b
def partitionsn2(d):
    acc = 1
    for i in d: # d has the multiplicities of factors of a
        acc *= 2 * i + 1 # multiply by two because we work with n^2, add one for the option of choosing none
    return acc // 2 + 1 # we double counted every possibility except for when a = b (which is always possible because n^2 has all even multiplicities)

primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
# recompute n from its factorization
def prod(d):
    acc = 1
    for i, exp in enumerate(d):
        acc *= primes[i] ** exp
    return acc

lowest_sol_known = None
# iterate over counts so that it checks all "reasonable" options
# no need for more than 15 primes, since 3^15 / 2 > 4000000
for a in range(1, 5):
    for b in range(max(a + 1, 4)):
        for c in range(max(b + 1, 3)):
            for d in range(c + 1):
                for e in range(d + 1):
                    for f in range(e + 1):
                        for g in range(f + 1):
                            for h in range(g + 1):
                                for i in range(h + 1):
                                    for j in range(i + 1):
                                        for k in range(j + 1):
                                            for l in range(k + 1):
                                                for m in range(l + 1):
                                                    for n in range(m + 1):
                                                        for o in range(n + 1):
                                                            counts = [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o]
                                                            p = partitionsn2(counts) # count how many partitions are possible for n^2
                                                            if p > 4000000 and (lowest_sol_known is None or prod(counts) < lowest_sol_known):
                                                                lowest_sol_known = prod(counts)
print(lowest_sol_known)

end = time.time()
print(end - start)