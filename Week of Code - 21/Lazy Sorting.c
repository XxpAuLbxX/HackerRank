#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char buf[81], *ptr;
    int j = 0, P[18]; 
    double n, sort, sum = 0.0, i = 1.0;
    // read in n
    fgets(buf, sizeof(buf), stdin); 
    buf[strcspn(buf, "\n")] = 0;
    n = strtol(buf, &ptr, 10);
    // read in Pi
    while(j < n) {
        scanf("%d", &P[j]);
        j++;
    }
    // While loop to run until precision is lost
    sort = 1.0 / n;
    while(sort > 0.0000000001) { 
        sum += (sort * i);
        sort /= n; // next probability
        i++;
    }
    printf("%0.6f", sum);
    return 0;
}