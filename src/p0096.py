# https://projecteuler.net/problem=96

import time

start = time.time()

FILENAME = "../data/sudoku96.txt"


def in_square(grid, val, i, j):
    top_left = (((i // 3) * 3), ((j // 3) * 3))
    for di in range(3):
        for dj in range(3):
            ni, nj = top_left[0] + di, top_left[1] + dj
            if ni == i and nj == j:
                continue
            if grid[ni][nj] == val:
                return True
    return False


def solve(grid):
    zeroes = []
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == 0:
                zeroes.append((i, j))
    stack = [(zeroes, grid)]
    while stack:
        z, grid = stack.pop()
        if len(z) == 0:
            return grid

        i, j = z.pop()
        for k in range(1, 10):
            if (
                k in grid[i]
                or k in [grid[el][j] for el in range(len(grid))]
                or in_square(grid, k, i, j)
            ):
                continue
            ngrid = [
                [grid[i][j] for j in range(len(grid[i]))] for i in range(len(grid))
            ]
            ngrid[i][j] = k
            stack.append(([t for t in z], ngrid))

    print("oops")
    return grid


def get_grids(filename):
    grids = []
    file = open(filename)
    lines = file.readlines()
    i = 0
    while i < len(lines):
        grid = [[0 for m in range(9)] for n in range(9)]
        for j in range(9):
            for k in range(9):
                grid[j][k] = int(lines[i + j + 1][k])
        i += 10
        grids.append(grid)
    return grids


grids = get_grids(FILENAME)
sum = 0
for i, grid in enumerate(grids):
    # print(i)
    solved = solve(grid)
    sum += 100 * solved[0][0] + 10 * solved[0][1] + solved[0][2]

print(sum)

end = time.time()
print(end - start)
