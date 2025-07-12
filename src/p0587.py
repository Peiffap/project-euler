# https://projecteuler.net/problem=587

import time
import math

start = time.time()

total_area = 1 - math.pi / 4  # area of the L-section is square minus quarter circle

n = 2
while True:  # binary search is not necessary
    # the intersection between the line and the first circle (centered in (1, 1))
    # is the point where y = x/n = 1 - sqrt(1 - (1 - x)^2)
    x_inter = (-math.sqrt(2) * n**(3/2) + n**2 + n) / (n**2 + 1)
    y_inter = x_inter / n
    area = x_inter * y_inter / 2  # the triangular area bounded by the line and the x-axis

    # numerically integrate under the quarter circle using the trapezoidal rule
    num_int = 0.
    steps = range(int(100000 * x_inter), 100000)
    for x1, x2 in zip(steps[:-1], steps[1:]):
        x1 /= 100000
        x2 /= 100000
        y1 = 1 - math.sqrt(1 - (1 - x1)**2)
        y2 = 1 - math.sqrt(1 - (1 - x2)**2)
        sliver = (x2 - x1) * (y1 + y2) / 2
        num_int += sliver
    
    #print(n, (area + num_int) / total_area)
    if (area + num_int) / total_area < 0.001:  # once the ratio is below 0.001, we have found the solution
        print(n)
        break
    n += 1

end = time.time()
print(end - start)
