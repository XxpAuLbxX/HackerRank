#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char buf[81], *ptr;
    int V, n, input;
    // read in V
    fgets(buf, sizeof(buf), stdin); 
    buf[strcspn(buf, "\n")] = 0;
    V = strtol(buf, &ptr, 10);
    // read in n
    fgets(buf, sizeof(buf), stdin); 
    buf[strcspn(buf, "\n")] = 0;
    n = strtol(buf, &ptr, 10);
    // loop n times until found
    for(int i=0; i < n; i++) {
        scanf("%d",&input);
        if(input == V) {
            printf("%d",i);
            break; // break out of loop when found
        }
    }
    return 0;
}