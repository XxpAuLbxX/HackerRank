X, Y, Z, N = (int(input()) for _ in range(4))
arr = []
for i in range(X+1):
    for j in range(Y+1):
        for k in range(Z+1):
            if (i + j + k) != N:
                arr.append([i, j, k])
print arr