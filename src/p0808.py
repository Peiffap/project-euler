# https://projecteuler.net/problem=808

import time
import math

start = time.time()


# checks whether n is a palindrome
def is_palindrome(n):
    return str(n) == str(n)[::-1]


# checks whether n is prime
def is_prime(n):
    if n < 2:
        return False
    if n % 2 == 0:
        return n == 2  # return False
    k = 3
    while k * k <= n:
        if n % k == 0:
            return False
        k += 2
    return True


s = 0  # sum of reversible prime squares
p = 13  # current number being checked, manually check everything smaller fails.
cnt = 0  # number of reversible prime squares found
while cnt < 50:  # we only want the first 50 reversible prime squares
    # primes need to start with 1 or 3
    # let n^2 != r^2 be the (non-palindromic) prime square and its reverse.
    # n^2 is square so needs to end in 0, 1, 4, 5, 6, or 9.
    # it's the square of a prime (and 2 and 5 don't work), so it ends in 1 or 9.
    # similarly, r^2 is the square of a prime too, so n^2 starts with 1 or 9 too.
    # this means n must start with 1 or 3.
    if str(p)[0] == "2":
        p = 3 * 10 ** (len(str(p)) - 1) + 1
    elif str(p)[0] == "4":
        p = 1 * 10 ** (len(str(p))) + 1
    if is_prime(p):
        pp = p**2  # compute the prime square

        if not is_palindrome(pp):
            sq = int(math.sqrt(int(str(pp)[::-1])))
            # check whether the reverse is also a prime square, and add if it is
            if sq * sq == int(str(pp)[::-1]) and is_prime(sq):
                s += pp
                cnt += 1
                print(cnt, p, pp, s)
    p += 1

print(s)

end = time.time()
print(end - start)
