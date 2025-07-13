# https://projecteuler.net/problem=205

import time
import itertools

start = time.time()

pp_odds = [0] * (
    36 + 1
)  # ith element will be the number of possible ways for pp to score i
cc_odds = [0] * (
    36 + 1
)  # ith element will be the number of possible ways for cc to score i

pp_possibilities = itertools.product(
    [1, 2, 3, 4], repeat=9
)  # generate all combinations for pp
cc_possibilities = itertools.product(
    [1, 2, 3, 4, 5, 6], repeat=6
)  # generate all combinations for cc
for pp in pp_possibilities:
    pp_odds[sum(pp)] += 1  # update number of ways
for cc in cc_possibilities:
    cc_odds[sum(cc)] += 1  # update number of ways

wins = 0  # number of ways to win for pp
# let p be pp's score and c be cc's score
# we want Pr(p > c)
# this is equivalent to sum_{P in pp totals} Pr(p = P) * Pr(c < P) = sum_{P in possibilities} Pr(p = P) * sum_{C < P} Pr(c = C)
for i, pp in enumerate(pp_odds):
    wins += pp * sum(cc_odds[:i])

wins /= (4**9) * (6**6)  # turn combinations into probabilities

print(f"{wins:.7f}")  # format output to have 7 decimals

end = time.time()
print(end - start)
