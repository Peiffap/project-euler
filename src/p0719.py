# https://projecteuler.net/problem=719

import time

start = time.time()


# apply a given split (as tuple) to a number
def apply_split(n, split):
    if split == ():
        return [n]
    return [int(str(n)[i:j]) for i, j in zip((0,) + split, split + (None,))]


# try to split the number
def try_split(n):
    q = [((), 1)]  # queue of splits to try; element is a tuple of split and current index
    while q:
        el = q[0]
        q = q[1:]
        su = sum(apply_split(n, el[0]))  # compute the sum after applying the split
        if su**2 == n:  # if a split with the correct sum is found, return True
            return True
        # only continue if the sum is bigger than needed (splitting can only decrease the sum)
        # and the index of the next split position is valid
        if su**2 > n and el[1] < len(str(n)):
            q.append((el[0] + (el[1],), el[1] + 1))  # first possibility, using the new split
            q.append((el[0], el[1] + 1))  # second possibility, not using the new split
    return False


s = 0
for i in range(4, 1000001):
    if try_split(i**2):
        #print(i)
        s += i**2


print(s)

end = time.time()
print(end - start)
