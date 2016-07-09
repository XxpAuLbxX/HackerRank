#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int T;
    long sumSq, sumNat, abs;
    scanf("%d",&T);
    int N[T];
    for(int i=0; i < T; i++) {
        sumSq = sumNat = 0;
        scanf("%d", &N[T]);
        for(int j=1; j <= N[T]; j++) {
            sumNat += (j*j);
            sumSq += j;
        }
        abs = (sumSq * sumSq) - sumNat;
        printf("%ld\n", abs);
    }
    return 0;
}