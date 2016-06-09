N = int(raw_input())
marks = {}
for i in range(0,N):
    name, math, phys, chem = raw_input().split(" ")
    marks[name] = (float(math) + float(phys) + float(chem)) / 3
print "%.2f" % marks[raw_input()]