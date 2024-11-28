# https://projecteuler.net/problem=491

import time
from itertools import permutations
import operator
from collections import Counter
from functools import reduce
from math import factorial

start = time.time()


# counts the number of permutations of a list with possible repetitions
# the number of permutations of a list is the factorial of the length of the list,
# divided by the product of the factorials of the multiplicity of each element
# (since sets of repeated elements are permuted with no effect)
def npermutations(l):
    num = factorial(len(l))
    mults = Counter(l).values()
    den = reduce(operator.mul, (factorial(v) for v in mults), 1)
    return num // den


digits = [0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9]  # digits to use
binints = [format(i, f'0{len(digits)}b') for i in range(2**(len(digits)))]
binints = [b for b in binints if b.count('1') == len(digits) // 2]
groups = []
for b in binints:
    g1 = tuple(digits[i] for i, c in enumerate(b) if c == '1')
    g2 = tuple(digits[i] for i, c in enumerate(b) if c == '0')
    # divisibility by n means the sums of digits in even and odds places is a multiple of 11
    # for each partition, we check whether this is the case, and avoid duplicates
    if sum(g1) % 11 == sum(g2) % 11 and (g1, g2) not in groups:
        groups.append((g1, g2))

# compute the number of ways each partition of digits can be permuted
cnt = 0
for i, (g1, g2) in enumerate(groups):
    #print(i, len(groups))
    # the leading digit can't be zero, so count only permutations where the first digit is nonzero
    # more precisely, we count the number of permutations of the list with the first digit removed,
    # and sum these, for each valid first digit
    npg1 = 0
    multiplicities = Counter(g1)
    for j, dig1 in enumerate(g1):
        if dig1 != 0:
            npg1 += npermutations(g1[:j] + g1[j + 1:]) // multiplicities[dig1]
    npg2 = npermutations(g2)  # for the even digits, no constraint
    cnt += npg1 * npg2  # both partitions can be permuted independently

print(cnt)  # print the count

end = time.time()
print(end - start)
