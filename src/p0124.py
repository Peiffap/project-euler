# https://projecteuler.net/problem=124

import time

start = time.time()


# computes the rad(x) for 1 <= x <= n
def radical(n):
    li = [1] * (n + 1)  # is i prime?
    i = 2
    while i <= n:  # while we aren't at n
        if li[i] == 1:  # if i hasn't been crossed off, it is prime
            li[i] = i  # if i is prime, its radical is i
            j = 2
            while i * j <= n:  # for all multiples of i up to n
                li[i * j] *= i  # i * j has prime factor i, so we update its radical
                j += 1
        i += 1
    return li


limit = 100000  # limit for this problem
rad = radical(limit)

# sort them by order of rad(n) first, n second
v = sorted([(rad[n], n) for n in range(1, limit + 1)])

print(v[10000 - 1][1])  # 10000 - 1 because indexing starts at 0

end = time.time()
print(end - start)
