# https://projecteuler.net/problem=74

import time

start = time.time()

lengths = [0] * 1000000

fact = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880] # precompute digit factorials
bc = 0 # number of length-60 paths

for i in range(len(lengths)):
    cnt = 1
    n = i
    seen = set([i]) # maintain list of numbers seen so far
    #print(i)
    while True:
        n = sum([fact[int(i)] for i in str(n)]) # compute sum of digit factorials
        cnt += 1
        if n in seen: # if seen before, length was number of steps minus one for the repeat
            lengths[i] = cnt - 1
            if cnt == 61: # if length-60 path
                bc += 1
            break
        else:
            seen.add(n) # add number to ones seen before

print(bc)

end = time.time()
print(end - start)