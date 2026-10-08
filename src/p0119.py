# https://projecteuler.net/problem=119

import time

start = time.time()

n = 10
counter = 0

precomputed_candidates = sorted(set(j**i for j in range(1, 100) for i in range(1, 10)))

for n in precomputed_candidates:
    digit_sum = sum(map(int, str(n)))
    if n < 10 or digit_sum == 1:
        continue
    m = 1
    exp = digit_sum**m
    while exp < n:
        exp = digit_sum**m
        m += 1
    if exp == n:
        counter += 1
        # print(f"{counter}: {n} = {digit_sum} ** {m}")
    if counter == 30:
        print(n)
        break

end = time.time()
print(end - start)
