# https://projecteuler.net/problem=61

import time
from itertools import permutations

start = time.time()

triangle = []
square = []
pentagonal = []
hexagonal = []
heptagonal = []
octogonal = []

n = 1
# generate all figurate numbers for the problem
while True:
    t = n * (n + 1) // 2  # triangle numbers
    if t > 9999:  # if greater than 9999, all 4-digit figurate numbers have been found
        break
    elif (
        t > 999 and t % 100 > 9
    ):  # has to have 4 digits and in order to be cyclic, can't have 0 as third digit
        triangle.append(t)

    s = n * n  # square numbers
    if 999 < s <= 9999 and s % 100 > 9:
        square.append(s)

    p = n * (3 * n - 1) // 2  # pentagonal numbers
    if 999 < p <= 9999 and p % 100 > 9:
        pentagonal.append(p)

    h6 = n * (2 * n - 1)  # hexagonal numbers
    if 999 < h6 <= 9999 and h6 % 100 > 9:
        hexagonal.append(h6)

    h7 = n * (5 * n - 3) // 2  # heptagonal numbers
    if 999 < h7 <= 9999 and h7 % 100 > 9:
        heptagonal.append(h7)

    o = n * (3 * n - 2)  # octogonal numbers
    if 999 < o <= 9999 and o % 100 > 9:
        octogonal.append(o)

    n += 1


# returns whether a permutation is cyclic
def iscyclic(perm):
    return (
        perm[0] % 100 == perm[1] // 100
        and perm[1] % 100 == perm[2] // 100
        and perm[2] % 100 == perm[3] // 100
        and perm[3] % 100 == perm[4] // 100
        and perm[4] % 100 == perm[5] // 100
        and perm[5] % 100 == perm[0] // 100
    )


plens = [0]  # number of figurates of each type
# remove figurates that can't be cyclic with the other possibilities recursively until nothing changes anymore
while [
    len(i) for i in [triangle, square, pentagonal, hexagonal, heptagonal, octogonal]
] != plens:
    plens = [
        len(i) for i in [triangle, square, pentagonal, hexagonal, heptagonal, octogonal]
    ]  # update previous lengths
    # print(plens)

    allnet = (
        square + pentagonal + hexagonal + heptagonal + octogonal
    )  # all except triangle
    allnes = (
        triangle + pentagonal + hexagonal + heptagonal + octogonal
    )  # all except square
    allnep = (
        triangle + square + hexagonal + heptagonal + octogonal
    )  # all except pentagonal
    allneh6 = (
        triangle + square + pentagonal + heptagonal + octogonal
    )  # all except hexagonal
    allneh7 = (
        triangle + square + pentagonal + hexagonal + octogonal
    )  # all except heptagonal
    allneo = (
        triangle + square + pentagonal + hexagonal + heptagonal
    )  # all except octogonal

    ns = []
    for type_, other in zip(
        [triangle, square, pentagonal, hexagonal, heptagonal, octogonal],
        [allnet, allnes, allnep, allneh6, allneh7, allneo],
    ):
        na = []
        # remove numbers that don't fit any cycle
        for ntype_ in type_:
            if ntype_ % 100 in [n // 100 for n in other] and ntype_ // 100 in [
                n % 100 for n in other
            ]:
                na.append(ntype_)
        ns.append(na)

    triangle, square, pentagonal, hexagonal, heptagonal, octogonal = ns

# loop over all possibilities (triangle and square last because they have more elements and allow the biggest optimization)
# all 6 numbers have to be distinct
for o in octogonal:
    for h7 in heptagonal:
        # print(o, h7)
        for h6 in hexagonal:
            for p in pentagonal:
                # p needs to follow or precede one of the other numbers in the cycle, or h6, h7 and o need to be consecutive in the cycle
                if (
                    p % 100 in [o // 100, h7 // 100, h6 // 100]
                    or s // 100 in [o % 100, h7 % 100, h6 % 100]
                    or (o % 100 == h6 // 100 and h6 % 100 == h7 // 100)
                    or (o % 100 == h7 // 100 and h7 % 100 == h6 // 100)
                    or (h7 % 100 == h6 // 100 and h6 % 100 == o // 100)
                    or (h7 % 100 == o // 100 and o % 100 == h6 // 100)
                    or (h6 % 100 == o // 100 and o % 100 == h7 // 100)
                    or (h6 % 100 == h7 // 100 and h7 % 100 == o // 100)
                    and len(set([p, h6, h7, o])) == 4
                ):
                    for s in square:
                        # s needs to follow or precede one of the other numbers in the cycle
                        if (
                            s % 100 in [o // 100, h7 // 100, p // 100, h6 // 100]
                            or s // 100 in [o % 100, h7 % 100, p % 100, h6 % 100]
                            and len(set([s, p, h6, h7, o])) == 5
                        ):
                            for t in triangle:
                                # t needs to follow and precede two of the other numbers in the cycle
                                if (
                                    t % 100
                                    in [
                                        o // 100,
                                        s // 100,
                                        p // 100,
                                        h6 // 100,
                                        h7 // 100,
                                    ]
                                    and t // 100
                                    in [o % 100, s % 100, p % 100, h6 % 100, h7 % 100]
                                    and len(set([t, s, p, h6, h7, o])) == 6
                                ):
                                    # if a cycle is possible
                                    if sorted(
                                        [n % 100 for n in [t, s, p, h6, h7, o]]
                                    ) == sorted(
                                        [n // 100 for n in [t, s, p, h6, h7, o]]
                                    ):
                                        # try all possible permutations
                                        # wlog, t is in first position
                                        for perm in permutations([s, p, h6, h7, o]):
                                            if iscyclic(
                                                (t,) + perm
                                            ):  # when a valid permutation is found, print its sum
                                                print(sum((t,) + perm))
                                                end = time.time()
                                                print(end - start)
                                                quit()
