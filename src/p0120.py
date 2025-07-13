# https://projecteuler.net/problem=120

import time

start = time.time()

# the only terms that can be in the remainder are 2 is n is even and 2na if n is odd
# for the given range of values of a, we should thus always take an odd n
# the ideal candidate is 2n = a - 1, which is possible iff a is odd
# when a is even, we can take 2n = a - 2 instead
s = 0
for a in range(3, 1001):
    if a % 2 == 0:
        s += a * (a - 2)
    else:
        s += a * (a - 1)
print(s)

end = time.time()
print(end - start)
