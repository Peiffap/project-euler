# https://projecteuler.net/problem=700

import time

start = time.time()

eu = 1504170715041707
mod = 4503599627370517

smallest = eu
s = eu

v = eu
n = 1

# compute modular inverse
def modular_inverse(a, m):
    return a if a <= 1 else m - (m // a) * modular_inverse(m % a, m) % m

while v > 1.6e7: # start by bringing down the upper bound through brute-force
    v = (v + eu) % mod
    n += 1
    if v < smallest: # if a smaller eulercoin has been found, add to sum and update smallest known
        smallest = v
        s += v
        #print(n, smallest, s)

mi = modular_inverse(eu, mod) # compute modular inverse: x such that eu * x = 1 % mod
# this is useful because after mi iterations, we have 1
# after 2mi iterations, we have 2
# etc. after i iterations we have i
# but every mod iterations, we reset, so we need to take this modulo mod

lowest_iter = mi

for i in range(1, v): # for the remaining values after brute-forcing
    td = (mi * i) % mod # number of iterations required to reach i
    if td <= lowest_iter: # this value is the smallest to have been reached in its minimum number of iterations, and is thus an eulercoin
        lowest_iter = td
        #print(i, td)
        s += i

print(s)

end = time.time()
print(end - start)
