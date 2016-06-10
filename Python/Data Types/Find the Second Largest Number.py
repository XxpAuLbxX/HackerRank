N = int(input())
lst = list(map(int, raw_input().split(' ')))
maxNum = max(lst)
while maxNum == max(lst):
    lst.remove(max(lst))
print max(lst)