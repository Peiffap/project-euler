# https://projecteuler.net/problem=68

import time

start = time.time()


# Order is 0, 1, 2; 3, 2, 4; 5, 4, 6; 7, 6, 8; 9, 8, 1.
def get_string(ring):
    print(ring)
    if ring[3] == min(ring[3], ring[5], ring[7], ring[9]):
        return "".join(
            [str(ring[i]) for i in [3, 2, 4, 5, 4, 6, 7, 6, 8, 9, 8, 1, 0, 1, 2]]
        )
    if ring[5] == min(ring[3], ring[5], ring[7], ring[9]):
        return "".join(
            [str(ring[i]) for i in [5, 4, 6, 7, 6, 8, 9, 8, 1, 0, 1, 2, 3, 2, 4]]
        )
    if ring[7] == min(ring[3], ring[5], ring[7], ring[9]):
        return "".join(
            [str(ring[i]) for i in [7, 6, 8, 9, 8, 1, 0, 1, 2, 3, 2, 4, 5, 4, 6]]
        )
    return "".join(
        [str(ring[i]) for i in [9, 8, 1, 0, 1, 2, 3, 2, 4, 5, 4, 6, 7, 6, 8]]
    )


strings = []

ring0 = 10
for ring1 in range(1, 10):
    for ring2 in range(1, 10):
        if ring2 == ring1:
            continue
        print(ring0, ring1, ring2)
        g = ring0 + ring1 + ring2
        for ring3 in range(1, 10):
            if ring3 in [ring1, ring2]:
                continue
            ring4 = g - ring2 - ring3
            if ring4 in [ring1, ring2, ring3] or not 1 <= ring4 <= 9:
                continue
            for ring5 in range(1, 10):
                if ring5 in [ring1, ring2, ring3, ring4]:
                    continue
                ring6 = g - ring4 - ring5
                if ring6 in [ring1, ring2, ring3, ring4, ring5] or not 1 <= ring6 <= 9:
                    continue
                for ring7 in range(1, 10):
                    if ring7 in [ring1, ring2, ring3, ring4, ring5, ring6]:
                        continue
                    ring8 = g - ring7 - ring6
                    if (
                        ring8 in [ring1, ring2, ring3, ring4, ring5, ring6, ring7]
                        or not 1 <= ring8 <= 9
                    ):
                        continue
                    ring9 = g - ring8 - ring1
                    if (
                        ring9
                        in [
                            ring1,
                            ring2,
                            ring3,
                            ring4,
                            ring5,
                            ring6,
                            ring7,
                            ring8,
                        ]
                        or not 1 <= ring9 <= 9
                    ):
                        continue
                    strings.append(
                        get_string(
                            [
                                ring0,
                                ring1,
                                ring2,
                                ring3,
                                ring4,
                                ring5,
                                ring6,
                                ring7,
                                ring8,
                                ring9,
                            ]
                        )
                    )

print(max(strings))

end = time.time()
print(end - start)
