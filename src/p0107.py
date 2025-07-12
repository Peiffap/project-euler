# https://projecteuler.net/problem=107

import time
from collections import defaultdict

start = time.time()

fo = open("../data/network107.txt", "r") # input file
f = list(fo)
fo.close()

edges = defaultdict(list) # edges[i] is a list of (w, d) for each edge with weight w between i and d
seen = set() # set of nodes that have been seen already
q = [] # list of edges to consider
s1 = 0 # sum of all edges

for i, l in enumerate(f):
    l = l.strip().split(',')
    for j, v in enumerate(l):
        if v != '-':
            s1 += int(v) # each edge counts twice
            edges[i].append((int(v), j))

# this is a straightforward implementation of Prim's MST algorithm
s2 = 0 # sum of MST edges
seen.add(0) # start with only node 0
q += edges[0] # add its edges to the queue
while len(seen) < len(edges): # as long as we haven't seen every edge
    w, d = min(q) # take the min weight edge
    seen.add(d) # add its unseen node d to seen
    s2 += w # update the sum of MST edges

    for e in edges[d]: # append the edges from d that lead to unseen nodes
        if e[1] not in seen:
            q.append(e)

    q.remove((w, d)) # remove the edge we just added

    for e in q: # remove all edges that lead to nodes we have already seen
        if e[1] in seen:
            q.remove(e)

print(s1//2 - s2)

end = time.time()
print(end - start)