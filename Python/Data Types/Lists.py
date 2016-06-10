N = input()
L = []
for __ in range(N):
    s = raw_input().split()
    cmd = s[0]
    args = s[1:]
    if cmd !="print":
        cmd += "("+ ",".join(args) +")"
        eval("L." + cmd)
    else:
        print L