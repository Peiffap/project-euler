# https://projecteuler.net/problem=86

import math
import time

start = time.time()

LIMIT = 1000000

# D <= W <= H
sols = 0
M = 1
while sols <= LIMIT:
    print(M - 1, sols)
    H = M
    for W in range(1, H + 1):
        for D in range(1, W + 1):
            bc2 = H * H + (W + D) ** 2
            a = int(math.sqrt(bc2))
            if a * a == bc2:
                sols += 1
                if sols > LIMIT:
                    print(M)
                    end = time.time()
                    print(end - start)
                    exit()
    M += 1
