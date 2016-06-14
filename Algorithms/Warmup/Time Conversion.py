#!/bin/python3

import sys


time = input().strip()
hrs, minu, sec = time.split(":")
sec, form = sec[:len(sec)//2], sec[len(sec)//2:]
hrs = int(hrs) % 12 
if form == "PM":
    hrs = hrs + 12
print(format(hrs, '02d') + ":" + minu + ":" + sec)