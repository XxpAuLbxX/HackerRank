#!/bin/python3

import sys

prim = 0 
sec = 0
n = int(input().strip())
a = []
for a_i in range(n):
    a_t = [int(a_temp) for a_temp in input().strip().split(' ')]
    a.append(a_t)
for i in range(n):
    prim += a[i][i]
    sec += a[n-i-1][i]
print(abs(prim - sec))