# https://projecteuler.net/problem=73

import time
import numpy as np

start = time.time()

d = 12000
cnt = 0

for i in range(2, d + 1):
    for a in range(i // 3, i // 2 + 1): # no need to check outside of this range
        if np.gcd(a, i) == 1 and 2 * a < i < 3 * a: # fraction is reduce is gcd = 1, other checks to deal with range issues
            #print(a, i)
            cnt += 1
print(cnt)

end = time.time()
print(end - start)