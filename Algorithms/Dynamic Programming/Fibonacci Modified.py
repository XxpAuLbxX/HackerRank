arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]
n = arr.pop()

for i in range(2, n):
    arr.append(arr[i-1]*arr[i-1] + arr[i-2])
print(arr[n-1])