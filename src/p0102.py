# https://projecteuler.net/problem=102

import time
import decimal

start = time.time()

fo = open("../data/triangles102.txt", "r") # open file
f = list(fo)
fo.close()

# using barycentric coordinates, the point is inside the triangle iff all coordinates are strictly positive
cnt = 0
px, py = 0, 0 # origin coordinates
for l in f:
    s = [int(x) for x in l.strip().split(',')] # s[i] is the ith coordinate
    ax, ay, bx, by, cx, cy = s[0], s[1], s[2], s[3], s[4], s[5] # read points a, b, c
    alpha = decimal.Decimal(((by - cy) * (px - cx) + (cx - bx) * (py - cy))) / decimal.Decimal(((by - cy) * (ax - cx) + (cx - bx) * (ay - cy)))
    if alpha > 0:
        beta = decimal.Decimal(((cy - ay) * (px - cx) + (ax - cx) * (py -cy))) / decimal.Decimal(((by - cy) * (ax - cx) + (cx - bx) * (ay - cy)))
        if  beta > 0:
            gamma = decimal.Decimal(1 - alpha - beta)
            if gamma > 0:
                cnt += 1
                #print(s, cnt)

print(cnt)

end = time.time()
print(end - start)