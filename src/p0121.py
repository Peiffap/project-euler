# https://projecteuler.net/problem=121

import time

start = time.time()

prob = 0.0  # probability of winning
for i in range(2**15):  # all possible outcomes can be written using 15 bits
    ff = format(i, '015b')  # 1 corresponds to picking the blue disc, 0 the red one.
    nblue = ff.count('1')  # count the number of blue discs picked
    if nblue >= 8:  # consider how likely this given configuration is
        p = 1.0
        for i, c in enumerate(ff):
            if c == '1':
                p *= 1/(i + 2)  # the odds of picking a blue disc in round i (zero-indexed)
            else:
                p *= (i + 1)/(i + 2)  # the odds of picking a red disc in round i
        prob += p  # sum the probabilities

print(int(1 // prob))  # the maximum payout is the inverse of the probability of winning, rounded down

end = time.time()
print(end - start)
