# https://projecteuler.net/problem=79

import time

start = time.time()

fo = open("../data/keylog79.txt", "r") # read input
f = list(fo)
fo.close()

# compute the shortest common supersequence of two sequences
def shortest_common_supersequence(s1, s2):
    dp = [] # (i, j) is the length of the shortest common supersequence of s1[:i], s2[:j]
    for i in range(len(s1) + 1):
        dp.append([])
        for j in range(len(s2) + 1):
            dp[i].append(0)
            if i == 0: # if nothing in s1, scs is s2[:j]
                dp[i][j] = j
            elif j == 0: # if nothing in s2, scs is s1[:i]
                dp[i][j] = i
            elif s1[i - 1] == s2[j - 1]: # if both have the same last character c, scs is scs(s1[:i-1], s2[:j-1]) + c
                dp[i][j] = dp[i - 1][j - 1] + 1
            else: # if both have different last characters c1 and c2, scs is the minimum between scs(s1[:i-1], s2[:j]) + c1 and scs(s1[:i], s2[:j-1]) + c2
                dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1])
    
    # now reconstruct the scs
    index = dp[len(s1)][len(s2)] # length of scs(s1, s2)
    s = ''
    i = len(s1)
    j = len(s2)
    while i > 0 and j > 0: # while we have to add parts of both strings still
        if s1[i - 1] == s2[j - 1]: # if the last character is the same, add it
            s += s1[i - 1]
            i -= 1
            j -= 1
        elif dp[i - 1][j] > dp[i][j - 1]: # otherwise add the character that leads to the shortest common supersequence
            s += s2[j - 1]
            j -= 1
        else:
            s += s1[i - 1]
            i -= 1
        index -= 1
    if i > 0: # add the remaining sequence when the other is empty
        s += s1[:i][::-1]
        index -= i
    elif j > 0:
        s += s2[:j][::-1]
        index -= j

    return s[::-1]

s = []
for l in f:
    s.append(l.strip()) # read the input

s = list(set(s)) # only consider uniques

rshortest = '' # the shortest common supersequence regardless of order
for p in range(len(s)): # loop over all possible permutations of the input
    sp = s[p:] + s[:p]
    shortest = ''
    nshortest = ''
    tr = ''
    while sp: # find a greedy shortest common supersequence of all passcodes in this order
        minlen = 151
        for si in sp:
            nscs = shortest_common_supersequence(shortest, si) # compute the scs over a subset of passcodes
            if len(nscs) < minlen: # if better than the best known for this order of passcodes, replace the best known
                minlen = len(nscs)
                nshortest = nscs
                tr = si
        shortest = nshortest
        sp.remove(tr)
    if rshortest == '' or int(shortest) < int(rshortest): # update the order-independent scs
        rshortest = shortest

print(rshortest)

end = time.time()
print(end - start)