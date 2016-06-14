#!/bin/python3

import sys

pos, neg, zer = 0, 0, 0
n = int(input().strip())
arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]
for i in arr:
    if i > 0: pos += 1
    elif i < 0: neg += 1
    else: zer += 1
print(format(pos/n, ".6f") + "\n" + format(neg/n, ".6f") + "\n" + format(zer/n, ".6f"))