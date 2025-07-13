# https://projecteuler.net/problem=51
#
# Validated.

import time
import queue

start = time.time()


# array of primality
def prime_sieve(n):
    li = [True] * n
    li[0] = False
    li[1] = False
    i = 2
    while i < n:
        if li[i]:
            j = 2
            while i * j < n:
                li[i * j] = False
                j += 1
        i += 1
    return li


sieve = prime_sieve(10000000)  # arbitrarily high number


# count how many primes appear when replacing *s
def check_family(s):
    if "*" not in s:  # can't expand if there are no *s
        return 0, [s]

    return cnt


best_cnt = 0

q = queue.Queue()
q.put("")

while True:
    root = q.get()
    # number of stars needs to be a nonzero multiple of three, or else we have at least 3 multiples of 3 in the family (and thus can't reach 8 primes)
    if (
        root
        and root[-1] in ["1", "3", "7", "9"]
        and root.count("*") != 0
        and root.count("*") % 3 == 0
    ):  # if last digit is even or 5
        # print(root)
        cnt = 0  # count number of primes in generated family
        family = [root.replace("*", str(i)) for i in range(10)]  # replace *s
        for f in family:
            if (
                f[0] != "0" and sieve[int(f)]
            ):  # can't have a leading zero and needs to be prime
                cnt += 1
        if cnt > best_cnt:  # keep track of highest number of primes seen
            best_cnt = cnt
            if best_cnt >= 8:
                for x in family:  # print the smallest prime in the family
                    if sieve[int(x)]:
                        print(x)
                        end = time.time()
                        print(end - start)
                        quit()
    for c in [str(i) for i in range(10)] + [
        "*"
    ]:  # generate new possibilities to add to queue
        if not root or root[0] != "0":
            q.put(root + c)
