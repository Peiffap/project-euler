# https://projecteuler.net/problem=57
#
# Validated.

import time

start = time.time()

cnt = 0
fracs = [(3, 2)]  # first iteration

for i in range(1000):
    if len(str(fracs[i][0])) > len(
        str(fracs[i][1])
    ):  # if more digits in numerator than denominator
        cnt += 1
    # let f_{i-1} = n/d
    # then f_i = 1 + 1 / (1 + f_{i-1}) = 1 + 1 / ((n + d) / d) = 1 + d / (n + d) = (n + 2d) / (n + d)
    fracs.append((fracs[-1][0] + 2 * fracs[-1][1], fracs[-1][0] + fracs[-1][1]))

print(cnt)
end = time.time()
print(end - start)
