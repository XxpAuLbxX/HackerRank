M = input()
set1 = set(map(int, raw_input().split(' ')))
N = input()
set2 = set(map(int, raw_input().split(' ')))
symm = set1.symmetric_difference(set2)
for n in sorted(list(symm)):
    print n