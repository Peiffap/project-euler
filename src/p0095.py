# https://projecteuler.net/problem=95

import time

start = time.time()


def divisor_sum(n):
    if n < 2:
        return 0
    sum = 1
    i = 2
    while i * i < n:
        if n % i == 0:
            sum += i + n // i
            if sum > 1000000:
                return sum
        i += 1
    if i * i == n:
        sum += i
    return sum


# Precompute divisor sums.
dsums = [divisor_sum(i) for i in range(1000001)]

chains = [[i] for i in range(1000001)]
max_len = 2
smallest = -1
for i, chain in enumerate(chains):
    ds = dsums[chain[-1]]
    while True:
        if ds == 1 or ds > 1000000:
            break
        if ds == chain[0]:
            if len(chain) > max_len:
                max_len = len(chain)
                smallest = min(chain)
            elif len(chain) == max_len:
                smallest = min(smallest, min(chain))
            break
        if ds in chain:
            break
        chain.append(ds)
        ds = dsums[ds]

end = time.time()
print(smallest)
print(end - start)
