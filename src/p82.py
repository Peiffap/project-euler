# https://projecteuler.net/problem=82

import time

start = time.time()

fo = open("../data/matrix82.txt", "r") # open input file
f = list(fo)
fo.close()

grid = [[int(i) for i in l.strip().split(',')] for l in f] # read the input into a 2D list

seen = set()

# basically Dijkstra's algorithm for shortest path in a weighted graph
q = [] # queue with positions to visit
for i in range(len(grid)):
    q.append((grid[i][0], i, 0, [(i, 0)])) # path sum, position in the matrix, path so far
s, i, j, path = min(q)
while j != len(grid) - 1: # while we haven't reached the right side
    #print(s, i, j)
    seen.add((i, j)) # node (i, j) has been reached with minimal path sum
    if i + 1 < len(grid): # if we can move down
        q.append((s + grid[i + 1][j], i + 1, j, path + [(i + 1, j)])) # add result of moving down to the queue
    if i - 1 >= 0: # if we can move up
        q.append((s + grid[i - 1][j], i - 1, j, path + [(i - 1, j)])) # add result of moving up to the queue
    if j + 1 < len(grid): # if we can move right
        q.append((s + grid[i][j + 1], i, j + 1, path + [(i, j + 1)])) # add result of moving right to the queue
    for e in q:
        if (e[1], e[2]) in seen:
            q.remove(e) # remove node (i, j) from the queue if it has already been reached with a lower path sum
    s, i, j, path = min(q) # next node to consider is the one with the lowest path sum

print(s)

end = time.time()
print(end - start)