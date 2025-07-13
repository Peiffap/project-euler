# https://projecteuler.net/problem=122

import time
import math

start = time.time()

# finding the most efficient exponentiation path corresponds to finding a minimal addition chain for k.
# additionally, for k < 12509, there exists a minimal Brauer chain,
# i.e. with each operation using the last element in the chain.

s = 0
for k in range(1, 201):  # loop over the values of k we need to find
    o = bin(k).count("1")
    ml = int(
        math.log2(k) + math.log2(o) - 2.13
    )  # bound for the minimal length of the addition chain
    found = False  # no addition chain of length l has been found yet
    while (
        not found
    ):  # loop until an addition chain of length l is found, using iterative deepening
        q = [(1,)]
        while q:  # depth-first search using a stack
            el = q.pop()
            if (
                el[-1] == k
            ):  # if the last element of the chain is k, we have found a chain
                s += (
                    len(el) - 1
                )  # first step of the chain does not count (no multiplication to find n)
                # print(i, len(el) - 1, el, s)
                found = True  # no more need to iteratively deepen
                break
            if len(el) < ml:  # only continue if the chain is not too long
                for known in (
                    el
                ):  # construct the next elements of the chain using the Brauer property
                    if (
                        el[-1] + known <= k
                    ):  # no need to build chains that reach above the target
                        q.append(el + (el[-1] + known,))
        ml += 1  # update the depth bound

print(s)  # print the sum

end = time.time()
print(end - start)
