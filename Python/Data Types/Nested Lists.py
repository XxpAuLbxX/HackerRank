N = int(input())
gradebook = []
for __ in range(N):
    gradebook.append([raw_input(), float(input())])

scores = sorted({s[1] for s in gradebook})
result = sorted(s[0] for s in gradebook if s[1] == scores[1])
print '\n'.join(result)