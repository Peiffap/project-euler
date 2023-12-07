# https://projecteuler.net/problem=816

import time
import numpy as np

start = time.time()

# compute squared distance to avoid taking roots
def dsq(a, b):
    return (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2

s = [290797] # starting seed
p = [] # a tuple per position

for i in range(1, 4000000):
    s.append(pow(s[i-1], 2, 50515093)) # compute coordinates
    if i % 2 == 1:
        #print(i)
        p.append((s[i - 1], s[i])) # create points

min_dist = dsq(p[0], p[1]) # keep track of the minimal distance

p.sort() # sort the points along their x coordinate, since indices don't matter

for i in range(len(p)):
    #print(i)
    for j in range(i + 1, len(p)): # only need to check starting from p_i
        if (p[j][0] - p[i][0]) ** 2 >= min_dist: # if the difference along x already exceeds the best known, move on
            break
        if dsq(p[i], p[j]) < min_dist: # update new best
            min_dist = dsq(p[i], p[j])


print(f'{np.sqrt(min_dist):.9f}') # print and format to 9 decimals

end = time.time()
print(end - start)
