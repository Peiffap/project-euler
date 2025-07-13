# https://projecteuler.net/problem=101

import time
import numpy as np

start = time.time()

i = 120  # largest known value in statement
INVSQRT = 1.0 / np.sqrt(2)  #
lasti = 21  # previous value

while True:
    # in order for n / i * (n - 1) / (i - 1) = 1/2, we need (n - 1) / (i - 1) < 1 / sqrt(2) < n / i
    n = int(INVSQRT * i) + 1
    if 2 * n * (n - 1) == i * (i - 1):  # if we've found a valid solution
        # print(i, n)
        if i > 1000000000000:  # print and end if it is sufficiently big
            print(n)
            end = time.time()
            print(end - start)
            quit()

        tmp = i
        # let i_n be the nth total number of balls for which a perfect 1/2 probability is possible
        # by playing with values, we observe that the ratio i_n / i_{n - 1} is always increasing
        # knowing i_n and i_{n - 1}, we can thus speculate that i_{n + 1} / i_n > i_n / i_{n - 1},
        # or equivalently, i_{n + 1} > i_n^2 / i_{n - 1}
        i = int(i * i / lasti)
        lasti = tmp
    i += 1
