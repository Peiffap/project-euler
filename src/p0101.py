# https://projecteuler.net/problem=101

import time

from functools import lru_cache

start = time.time()


# compute the function underlying the sequence we want to model
def f(x):
    return 1 - x + x**2 - x**3 + x**4 - x**5 + x**6 - x**7 + x**8 - x**9 + x**10


# compute n * (n - 1) * ... * (n - i + 1)
@lru_cache(maxsize=None)
def fact(n, i):
    if n == i:  # base case
        return 1
    return n * fact(n - 1, i)  # recursive formula


x = list(range(1, 14))  # list of x values of our sequence
y = [f(xi) for xi in x]  # list of y values of our sequence


# recursively compute forward divided differences
# this is sufficient as x_i = x_0 + i
@lru_cache(maxsize=None)
def divided_difference(k, j):
    if j == 0:  # base case
        return y[k]
    return (divided_difference(k + 1, j - 1) - divided_difference(k, j - 1)) / (
        x[k + j] - x[k]
    )


# Newton's form of the optimal interpolation of degree k
def newton(k):
    return lambda n: int(
        sum(
            [
                (fact(n - x[0], n - x[0] - i)) * divided_difference(0, i)
                for i in range(k + 1)
            ]
        )
    )


s = 0  # sum of FITs
for k in range(
    11
):  # for each possible degree of the optimal polynomial where there is an incorrect term
    OP = newton(k)  # compute the optimal polynomial
    FIT = OP(x[k + 1])  # compute the first incorrect term
    if (
        FIT != y[k + 1]
    ):  # always true if k is less than the degree d of the sequence-generating polynomial (i.e. k < d = 10 here)
        s += FIT
print(s)

end = time.time()
print(end - start)
