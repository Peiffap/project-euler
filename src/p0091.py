# https://projecteuler.net/problem=91

import time
import itertools

start = time.time()

lr = list(range(50 + 1))  # possible coordinates
prod = itertools.product(lr, repeat=4)  # all possible coordinate combinations

cnt = 0  # number of right angle triangles
for x1, y1, x2, y2 in prod:  # for all coordinates
    # some basic checks to ensure the triangle is well-formed
    if (
        not (x1 == 0 and x2 == 0)
        and not (y1 == 0 and y2 == 0)
        and not (x1 == 0 and y1 == 0)
        and not (x2 == 0 and y2 == 0)
        and not (x1 == x2 and y1 == y2)
    ):
        edges = [
            x1**2 + y1**2,
            x2**2 + y2**2,
            (x2 - x1) ** 2 + (y2 - y1) ** 2,
        ]  # compute edge lengths
        if (
            sum(edges) == 2 * max(edges)
        ):  # a triangle has a right angle iff a^2 + b^2 = c^2, or if a^2 + b^2 + c^2 = 2c^2
            cnt += 1

print(cnt // 2)  # every triangle got counted twice, so we divide by two

end = time.time()
print(end - start)
