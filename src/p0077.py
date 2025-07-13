# https://projecteuler.net/problem=77

import time
import functools

start = time.time()


# generate list of primes up to n
def primes(n):
    p = []
    li = [True] * n
    li[0] = False
    li[1] = False
    i = 2
    while i < n:
        if li[i]:
            p.append(i)
            j = 2
            while i * j < n:
                li[i * j] = False
                j += 1
        i += 1
    return p


limit = 100  # limit to reduce the runtime - this algorithm scales extremely poorly because of the many layers in the recurrence relation

pl = primes(limit)  # list of primes up to our limit
pindices = [0] * limit  # list of indices to speed up computation
for i, p in enumerate(pl):
    pindices[p] = i  # p is the ith prime

Pn = [
    [(p, p) for p in pl]
]  # Pn[0] = all possible (s = p_1 + ... + p_{i+1}, p_1 < ... < p_{i+1}) tuples such that s <= limit
i = 0
while True:
    nps = []
    for j in Pn[i]:  # for each tuple of size i
        for k in Pn[0][
            pindices[j[-1]] + 1 :
        ]:  # for each prime p_{i+1} > p_i > ... > p_1
            if j[0] + k[-1] <= limit:  # if s = p_1 + ... + p_{i + 1} <= limit
                nps.append(
                    tuple([j[0] + k[-1]] + list(j[1:]) + [k[-1]])
                )  # add to tuples for size i + 1
            else:
                break
        if not nps:  # nothing was added, so no point in looking at tuples with higher starting sums
            break
    if nps:  # avoid adding empty arrays if the sum limit is exceeded
        nps.sort()  # sort to make determining breaks easier
        Pn.append(nps)
    else:
        break
    i += 1


# observation: let pp(n) be the number of ways n can be written as a sum of primes, and let P_n be the set of primes less than or equal to n
# base case: let pp(n) = 1 if n = 0, pp(n) = 0 if n < 0
# then we have pp(n) = sum_{p1 in P_n} pp(n - p1) - sum_{(p1, p2) in P_n^2, p1 < p2} pp(n - p1 - p2) + ... + (-1)^{n-1} sum_{(p1, ..., pn) in P_N^n, p1 < ... < pn} pp(n - p1 - ... - pn)
# we can speed this up by only considering these terms until p1 + ... + pi > n
@functools.lru_cache(maxsize=None)  # use cache for memoization
def pp(n):
    if (
        n == 0
    ):  # base case - the case n < 0 is handled by checking we never subtract more from n than n
        return 1
    ppn = 0
    sign = 1
    for i in range(len(Pn)):  # number of primes to remove
        for s in Pn[i]:  # for each set of i primes summing to i
            if s[0] <= n:  # check we aren't negative
                ppn += sign * pp(n - s[0])  # recurrence relation
            else:
                break
        sign = -sign  # (-1)^{n-1}
    return ppn


for n in range(limit):
    if pp(n) > 5000:  # first value to exceed 5000 is the answer
        print(n)
        break

end = time.time()
print(end - start)
