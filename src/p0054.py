# https://projecteuler.net/problem=54

import time

start = time.time()

fo = open("../data/poker54.txt", "r")  # read input
f = list(fo)
fo.close()


# flatten a list
def flatten(xss):
    return [x for xs in xss for x in xs]


# return a hand's rank and its values in evaluation order for that rank
def grade_hand(hand):
    hand.sort()  # sort the hand to get smaller values first; suit order is irrelevant
    values = [c[0] for c in hand]  # values in the hand
    suits = [c[1] for c in hand]  # suits in the hand

    cnts = sorted(
        [(values.count(i), i) for i in sorted(list(set(values)))]
    )  # ordered list of (cnt, v) where cnt is the count of v
    valcounts = [j[0] for j in cnts]  # just the counts

    if len(set(suits)) == 1:
        if values[0] == "I":  # royal flush
            return 10, flatten([[i[1]] * i[0] for i in cnts[::-1]])
        elif ord(values[-1]) - ord(values[0]) == 4:  # straight flush
            return 9, flatten([[i[1]] * i[0] for i in cnts[::-1]])
        else:  # flush
            return 6, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    elif valcounts == [1, 4]:  # four of a kind
        return 8, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    if valcounts == [2, 3]:  # full house
        return 7, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    elif valcounts == [1, 1, 1, 1, 1]:
        if ord(values[-1]) - ord(values[0]) == 4:  # straight
            return 5, flatten([[i[1]] * i[0] for i in cnts[::-1]])
        else:  # high card
            return 1, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    elif valcounts == [1, 1, 3]:  # three of a kind
        return 4, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    elif valcounts == [1, 2, 2]:  # two pairs
        return 3, flatten([[i[1]] * i[0] for i in cnts[::-1]])
    elif valcounts == [1, 1, 1, 2]:  # one pair
        return 2, flatten([[i[1]] * i[0] for i in cnts[::-1]])


# replace values so sorting is easier
def repl(s):
    s = s.replace("A", "M")
    s = s.replace("K", "L")
    s = s.replace("Q", "K")
    s = s.replace("J", "J")
    s = s.replace("T", "I")
    s = s.replace("9", "H")
    s = s.replace("8", "G")
    s = s.replace("7", "F")
    s = s.replace("6", "E")
    s = s.replace("5", "D")
    s = s.replace("4", "C")
    s = s.replace("3", "B")
    s = s.replace("2", "A")
    return s


cnt = 0
for line in f:
    hands = line.strip().split()
    hands = [repl(hand) for hand in hands]  # make input more easily sortable
    h1, h2 = hands[:5], hands[5:]  # split hands
    gh1, v1 = grade_hand(h1)  # grade hands
    gh2, v2 = grade_hand(h2)
    if gh1 > gh2 or gh1 == gh2 and v1 > v2:  # if player 1 wins, update count of wins
        cnt += 1

print(cnt)

end = time.time()
print(end - start)
