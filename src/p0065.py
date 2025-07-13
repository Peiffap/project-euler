# https://projecteuler.net/problem=65

import time

start = time.time()

sequence = [2, 1, 2, 1]  # sequence

nconv = 100

for i in range(35):
    sequence += [
        1,
        sequence[-2] + 2,
        1,
    ]  # find the useful terms in the continued fraction

sequence = sequence[:nconv][
    ::-1
]  # only go up to 100th convergent, and start from the bottom

# initial setup: start from f, build up from there
# f_i  = (s_0 + 1/f_i-1), until the end
frac = (sequence[0], 1)
sequence = sequence[1:]

while sequence:
    n, d = frac
    frac = (sequence[0] * n + d, n)  # same logic: f_{i-1} = n/d -> f_i = s_0 d / n
    sequence = sequence[1:]

n, d = frac

print(sum(int(i) for i in str(n)))  # sum digits of numerator
end = time.time()
print(end - start)
