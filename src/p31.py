# https://projecteuler.net/problem=31
#
# Validated.

import time
from collections import defaultdict

start = time.time()

sols = defaultdict(set)

sols[0].add((0, 0, 0, 0, 0, 0, 0, 0)) # 1, 2, 5, 10, 20, 50, 100, 200

additions = [1, 2, 5, 10, 20, 50, 100, 200]

for i in range(201):
    for n, j in zip(range(8), additions):
        for tup in sols[i]:
            a = list(tup)
            a[n] += 1
            if i + j <= 200:
                sols[i + j].add(tuple(a))
    if i != 200:
        sols[i] = set()

print(len(sols[200]))

end = time.time()
print(end - start)