# https://projecteuler.net/problem=31
#
# Validated.

import time
from collections import defaultdict

start = time.time()

sols = defaultdict(set)  # use set to only count uniques

sols[0].add((0, 0, 0, 0, 0, 0, 0, 0))  # one solution to get 0

additions = [1, 2, 5, 10, 20, 50, 100, 200]  # coin types

for i in range(201):  # go up to 200
    for n, j in enumerate(additions):
        for tup in sols[i]:  # get solutions to reach i pence
            a = list(tup)
            a[n] += 1  # add one to the appropriate coin type
            if i + j <= 200:  # only compute if useful for our solution
                sols[i + j].add(tuple(a))  # add new way to reach i+j pence
    if i != 200:
        sols[i] = set()  # forget about earlier values, not useful anymore

print(len(sols[200]))

end = time.time()
print(end - start)
