# https://projecteuler.net/problem=60
#
#

import time
import networkx as nx
import numpy as np

start = time.time()


# list of primes
def primes(n, prime_list=False):
    p = []
    li = [True] * n
    li[0] = False
    li[1] = False
    i = 2
    while i < n:
        if li[i]:
            if prime_list:
                p.append(i)
            j = 2
            while i * j < n:
                li[i * j] = False
                j += 1
        i += 1
    if prime_list:
        return p, li
    else:
        return li


pr, _ = primes(
    26033, True
)  # solution found with sum = 26033, hence no need to explore higher

sieve = primes(
    99999999
)  # arbitrarily high number for some speedup of primality checking


# primality check
def is_prime(p):
    if p < len(sieve):
        return sieve[p]
    else:
        i = 2
        for i in range(2, int(np.sqrt(p)) + 1):
            if p % i == 0:
                return False
        return True


am = np.zeros((len(pr), len(pr)))  # adjacency matrix
for i, p in enumerate(pr):
    # print(p)
    for j, q in enumerate(pr):
        if (
            q + p >= 26033
        ):  # no need to check if sum > 26033 because a solution is known with sum = 26033
            break
        if (
            q > p and is_prime(int(str(p) + str(q))) and is_prime(int(str(q) + str(p)))
        ):  # primes are connected if their concats are prime
            am[i][j] = 1
            am[j][i] = 1

G = nx.from_numpy_matrix(
    am
)  # a clique means all pairs of primes in the clique are prime when concatenated
cliques = [x for x in nx.find_cliques(G) if len(x) >= 5]  # only take length 5
# print([[pr[j] for j in i] for i in cliques]) # match indices to primes
print(min([sum([pr[j] for j in i]) for i in cliques]))  # compute minimum sum

end = time.time()
print(end - start)
