# https://projecteuler.net/problem=125

import time

start = time.time()


# checks if a number is a palindrome
def is_palindrome(n):
    return str(n) == str(n)[::-1]


squares = [i**2 for i in range(10001)]  # precompute squares
palsq = set()  # palindromic sums of consecutive squares

for i in range(
    1, 10000
):  # smallest consecutive square can't be larger than 1e4 (sum can only go up to 1e8)
    # print(i)
    for j in range(
        i + 1, 10001
    ):  # largest consecutive square must be strictly larger than smallest
        ssq = sum(
            squares[i : j + 1]
        )  # compute sum of consecutive squares from i to j (inclusive)
        if ssq >= 10**8:  # the sum is already too large, so adding terms can never work
            break
        if is_palindrome(ssq):  # if the sum is a palindrome, add it to the set
            palsq.add(ssq)

print(sum(palsq))  # print the sum of all palindromic sums

end = time.time()
print(end - start)
