# https://projecteuler.net/problem=686

# WIP

import time
import numpy as np
import decimal

start = time.time()

count = 0

# log(1230...0) <= log(123...) < log(1240...0)
# <=> log(1.23) <= log(123...) mod 1 < log(1.24)
l123 = np.emath.log2(decimal.Decimal(1.23))
l124 = np.emath.log2(decimal.Decimal(1.24))

n = decimal.Decimal(0)

l2 = np.emath.log10(decimal.Decimal(2)) # log10(2^{n+1}) = log10(2) + log10(2^n)
i = 0

while count < 678910:
    n += l2
    i += 1
    if l123 <= n % 1 < l124: # if we are between logs, the number has the form 123...
        count += 1
        n %= 1

print(i)

end = time.time()
print(end - start)
