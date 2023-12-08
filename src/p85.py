# https://projecteuler.net/problem=85

import time

start = time.time()

goal = 2000000 # number of rectangles we want
best = goal ** 2 # use squared distance to simplify finding closest
bk = -1 # best known grid area

w = 1
while True: # grid width
    row = w * (w + 1) // 2
    for h in range(1, w + 1): # grid height (without loss of generality less than or equal to width)
        s = 0
        if h == 1:
            s = row # speedup if only one height is possible
        else:
            for rw in range(1, w + 1): # rectangle width
                for rh in range(1, h + 1): # rectangle height
                    s += (w + 1 - rw) * (h + 1 - rh) # as many (rw, rh) rectangles as positions for top left corner

        os = s
        #print(w, h, s)
        s = (s - goal) ** 2 # squared distance
        if s <= best: # update if new best is found
            best = s
            bk = w * h

        if os >= goal: # if we are above 2000000, making the grid higher will never be better
            break
    if row >= goal: # check if increasing grid width still makes sense for our goal
        break
    else:
        w += 1

print(bk)

end = time.time()
print(end - start)