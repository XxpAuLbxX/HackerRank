#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char buf[81], *ptr;
    int n, i = 0, P[18];
    // read in n
    fgets(buf, sizeof(buf), stdin); 
    buf[strcspn(buf, "\n")] = 0;
    n = strtol(buf, &ptr, 10);
    // read in Pi
    while(i < n) {
        scanf("%d", &P[i]);
        i++;
    }
    return 0;
}