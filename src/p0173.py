# https://projecteuler.net/problem=173

import time

start = time.time()

l = 1000000 # maximum number of tiles
ways = 0 # number of ways a hollow square lamina can be formed with up to l tiles
m = 1 # thickness of the hsl

n_max = (l // 4 + m * m) // m # n^2 - (n - 2m)^2 <= l -> n <= (l / 4 + m^2) / m
while n_max >= 2 * m: # while n is sufficient to have thickness m
    ways += n_max - 2 * m
    m += 1
    n_max = (l // 4 + m * m) // m

print(ways)

end = time.time()
print(end - start)