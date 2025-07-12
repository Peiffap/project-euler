# https://projecteuler.net/problem=72

import time

start = time.time()

d = 1000000

phi = [0] * (d + 1) # precompute totient
for i in range(d + 1):
    phi[i] = i

# properties:
# 1. if p is prime, phi(p) = p - 1
# 2. if p is prime, phi(p^k) = p^k (1 - 1 / p)
# 3. if gcd(a, b) = 1, phi(ab) = phi(a) phi(b)
for i in range(2, d + 1):
    if phi[i] == i: # i is prime
        j = i
        while j <= d: # sieve-like loop
            phi[j] -= phi[j] / i
            j += i

print(int(sum(phi[2:]))) # the number of fractions is the sum of totients

end = time.time()
print(end - start)