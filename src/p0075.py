# https://projecteuler.net/problem=75

import time

start = time.time()

# integer sided right angle triangle -> a, b, c solution to a^2 + b^2 = c^2
limit = 1500000
L = [set()]
for i in range(limit): # use sets to avoid double-counting
    L.append(set())

# Euclid's modified method for generating Pythagorean triples:
# 1. pick two integers m > n > 0, and a third multiplier k > 0
# 2. (a, b, c) = (k (m^2 - n^2), 2kmn, k (m^2 + n^2)) generates all possible Pythagorean triples
m = 2
while 2 * m * m < limit: # independently of k or n, this can never lead to a + b + c <= limit
    #print(m)
    n = 1
    while n < m:
        k = 1
        while 2 * k * m * (m + n) <= limit: # sum of three sides
            a = k * (m * m - n * n)
            b = k * 2 * m * n
            c = k * (m * m + n * n)
            if a < b:
                L[a + b + c].add((a, b, c))
            else:
                L[a + b + c].add((b, a, c))
            k += 1
        n += 1
    m += 1

# count how many lengths have exactly one triple
cnt = 0
for i in range(limit + 1):
    if len(L[i]) == 1:
        cnt += 1

print(cnt)

end = time.time()
print(end - start)