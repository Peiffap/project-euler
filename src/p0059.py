# https://projecteuler.net/problem=59

import time
import operator

start = time.time()

fo = open("../data/cipher59.txt", "r")
f = list(fo)
fo.close()


# decrypt a string by bitwise xoring with the given key
def decrypt(s, key):
    ns = ""
    for i, c in enumerate(s):
        ns += chr(operator.xor(ord(c), ord(key[i % len(key)])))
    return ns


# count how many words from a list appear in a string
def cnt_words(s, li):
    cnt = 0
    for w in li:
        if w in s:
            cnt += 1
    return cnt


# a list of some of the most common words in the English language
# https://en.wikipedia.org/wiki/Most_common_words_in_English
common_words = [
    "I",
    "the",
    "The",
    "be",
    "Be",
    "to",
    "To",
    "of",
    "Of",
    "and",
    "And",
    "a",
    "A",
    "in",
    "In",
    "that",
    "That",
    "have",
    "Have",
    "it",
    "It",
    "for",
    "For",
    "not",
    "Not",
    "on",
    "On",
    "with",
    "With",
]

s = ""
for c in f[0].strip().split(","):  # get input
    s += chr(int(c))

for i in range(26):
    for j in range(26):
        for k in range(26):
            key = (
                chr(ord("a") + i) + chr(ord("a") + j) + chr(ord("a") + k)
            )  # loop over all possible length-3 lowercase keys
            # print(key)
            ns = decrypt(s, key)  # decrypt and obtain new string
            if (
                cnt_words(ns, common_words) > 10
            ):  # count common words, 10 is a random ~1/3 threshold
                # print(ns) # sanity check to see if the threshold makes sense
                print(sum([ord(c) for c in ns]))  # print solution
                end = time.time()
                print(end - start)
                quit()
