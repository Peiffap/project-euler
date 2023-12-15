# https://projecteuler.net/problem=124

import time

start = time.time()

# computes the rad(x) for 1 <= x <= n
def radical(n):
    l = [1] * (n + 1) # is i prime?
    i = 2
    while i <= n: # while we aren't at n
        if l[i] == 1: # if i hasn't been crossed off, it is prime
            l[i] = i # if i is prime, its radical is i
            j = 2
            while i * j <= n: # for all multiples of i up to n
                l[i * j] *= i # i * j has prime factor i, so we update its radical
                j += 1
        i += 1
    return l

limit = 100000 # limit for this problem
rad = radical(limit)

v = [None for _ in range(limit + 1)]
for n in range(limit + 1):
    v[n] = (rad[n], n) # make sorting easier

v = v[1:] # remove n = 0
v.sort() # sort them by order of rad(n) first, n second

print(v[10000 - 1][1]) # 10000 - 1 because indexing starts at 0

end = time.time()
print(end - start)