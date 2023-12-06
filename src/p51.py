# https://projecteuler.net/problem=51
#
# Validated.

import time
import queue

start = time.time()

def prime_sieve(n):
    l = [True] * n
    l[0] = False
    l[1] = False
    i = 2
    while i < n:
        if l[i]:
            j = 2
            while i * j < n:
                l[i * j] = False
                j += 1
        i += 1
    return l

sieve = prime_sieve(10000000)

def check_family(s):
    if not '*' in s:
        return 0, [s]
    cnt = 0
    family = [s.replace('*', str(i)) for i in range(10)]
    for f in family:
        if f[0] != '0' and sieve[int(f)]:
            cnt += 1
    return cnt, family

best_cnt = 0

q = queue.Queue()
q.put('')

while True:
    root = q.get()
    if root and root[-1] in ['1', '3', '5', '7', '9']:
        cnt, f = check_family(root)
        if cnt > best_cnt:
            best_cnt = cnt
            if best_cnt >= 8:
                for x in f:
                    if sieve[int(x)]:
                        print(x)
                        end = time.time()
                        print(end - start)
                        quit()
    for c in [str(i) for i in range(10)] + ['*']:
        if not root or root[0] != '0':
            q.put(root + c)