# https://projecteuler.net/problem=719

import time

start = time.time()


def apply_split(n, split):
    if split == ():
        return [n]
    return [int(str(n)[i:j]) for i, j in zip((0,) + split, split + (None,))]


def try_split(n):
    q = [((), 1)]
    while q:
        el = q[0]
        q = q[1:]
        su = sum(apply_split(n, el[0]))
        if su**2 == n:
            return True
        if su**2 > n and el[1] < len(str(n)):
            q.append((el[0] + (el[1],), el[1] + 1))
            q.append((el[0], el[1] + 1))
    return False


s = 0
for i in range(4, 1000001):
    if try_split(i**2):
        print(i)
        s += i**2


print(s)

end = time.time()
print(end - start)
