# https://projecteuler.net/problem=918

import time
import functools

# S(N) = \sum_{n = 1}^N a_n
#      = \sum_{k = 1}^{N//2} a_{2k} + \sum_{k = 0}^{(N-1)//2} a_{2k + 1}
#      = 2 S(N//2) + (1 + \sum_{k = 1}^{(N-1)//2} a_k - 3a_{k+1}
#      = 2 S(N//2) + 1 + S((N-1)//2) - 3 \sum_{k = 1}^{(N-1)//2} a_{k+1}
#      = 2 S(N//2) + 1 + S((N-1)//2) - 3 (\sum_{k = 1}^{(N-1)//2 + 1} a_k) + 3 a_1
#      = 2 S(N//2) + 4 + S((N-1)//2) - 3 S((N-1)//2 + 1)
#
# S(2m) = -S(m) + 4 + S(m - 1)
# S(2m + 1) = 3 S(m) + 4 - 3 S(m + 1)

start = time.time()


@functools.cache
def S(N):
    if N <= 1:
        return N
    if N % 2 == 0:
        return -S(N // 2) + 4 + S(N // 2 - 1)
    return 3 * S(N // 2) + 4 - 3 * S(N // 2 + 1)


print(S(1_000_000_000_000))

end = time.time()
print(end - start)