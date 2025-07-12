# https://projecteuler.net/problem=138

import time

start = time.time()

# integer square root
def isqrt(n):
    x = n
    y = (2 ** ((n.bit_length() + 1) // 2)) - 1 # first guess
    while y < x: # once both values are equal, we're done
        x = y
        y = (x + n // x) // 2 # update guess
    return x * x == n, x # is n a perfect square, and its integer square root

s = 0 # sum
cnt = 0 # number of solutions found
b = 16 # first guess for base length
found = False
lastb = 1 # last valid base length
while cnt < 12:
    h = [b - 1, b + 1] # possible heights for a given base length
    for index, hi in enumerate(h):
        ps, sr = isqrt(b ** 2 // 4 + hi ** 2)
        if ps: # if we've found a perfect square, the triangle is valid
            #print(b, b / lastb, index)
            found = True # solution found for this value of b
            s += sr # update the sum
            cnt += 1 # update count
            if cnt == 12: # print solution if done
                print(s)
    # we observe that the ratio of b_n to b_{n - 1} is nearly always the same,
    # so we use this to speed up the computation (piecewise, because the ratio isn't monotonous)
    if found:
        #lastb = b
        if b < 10000:
            b *= 17
        elif b < 1000000:
            b = int(17.94 * b)
        elif b < 15000000:
            b = int(17.94426 * b)
        else:
            b = int(17.9442718 * b)
        b -= b % 16 # empirically, b has to always be a multiple of 16
        found = False
    else:
        b += 16 # multiple of 16

end = time.time()
print(end - start)