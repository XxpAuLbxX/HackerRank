#!/bin/python3

import sys

space = ' '
stair = '#'
n = int(input().strip())
for i in range(n):
    print(space*(n-i-1) + stair*(i+1))