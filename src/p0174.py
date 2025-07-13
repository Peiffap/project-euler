# https://projecteuler.net/problem=174

import time

start = time.time()

nt = 1000000  # maximum number of tiles
nt4 = nt // 4
ways = [0] * (nt + 1)
m = 1  # thickness of the hsl
n_max = nt4 // m + m  # n^2 - (n - 2m)^2 <= l -> n <= (l / 4 + m^2) / m
while n_max >= 2 * m:  # while n is sufficient to have thickness m
    for i in range(
        2 * m + 1, n_max + 1
    ):  # for all possible outer lengths at this thickness
        ways[4 * m * (i - m)] += 1  # add 1 to total tiles used
    m += 1
    n_max = nt4 // m + m

n = 0  # number of hsl with total tile count less than or equal to 10
for i in range(1, 11):
    n += ways.count(i)  # add number of hsl with total tile count equal to i

print(n)

end = time.time()
print(end - start)
