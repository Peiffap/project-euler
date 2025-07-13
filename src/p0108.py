# https://projecteuler.net/problem=108

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

start = time.time()

limit = 1000000  # limit to speed up computation


# generate list of primes up to n
def primes(n):
    p = []
    li = [True] * n  # is i prime?
    li[0] = False
    li[1] = False
    i = 2
    while i < n:  # while we aren't at n
        if li[i]:  # if i hasn't been crossed off, it is prime
            p.append(i)
            j = 2
            while i * j < n:
                li[i * j] = False  # multiples of i aren't prime
                j += 1
        i += 1
    return p


pl = primes(limit)  # precompute primes


# compute the prime factors (with multiplicity) of n
def prime_factors(n):
    factors = {}
    for p in pl:
        while n % p == 0:  # count how many times p divides n
            if p in factors.keys():
                factors[p] += 1
            else:
                factors[p] = 1
            n //= p
        if n == 1:  # the factorization is done
            break
    return factors


# compute how many unique ways there are to write n^2 = p_1^(2d_1) * ... * p_i^(2d_i) as a product ab with a <= b
def partitionsn2(d):
    acc = 1
    for i in d.values():  # d has the factors of n
        acc *= (
            2 * i + 1
        )  # multiply by two because we work with n^2, add one for the option of choosing none
    return (
        acc // 2 + 1
    )  # we double counted every possibility except for when a = b (which is always possible because n^2 has all even multiplicities)


for n in range(2, limit):
    p = partitionsn2(prime_factors(n))  # count how many partitions are possible for n^2
    if p > 1000:
        print(n)
        break

end = time.time()
print(end - start)
