#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main(){
    int T, M, N;
    scanf("%d",&T);
    for(int i=0; i < T; i++) {
        scanf("%d", &M);
        scanf("%d", &N);
        int Price[N];
        // Place prices in array
        for(int j=0; j < N; j++) {
            scanf("%d", &Price[j]);
        }
        // Non-optimized n^2 searching
        for(int j=0; j < N; j++) {
            for(int k=1; k < N; k++) {
                // Avoid same index
                if(j == k) 
                    break;
                // Print indexes and exit both loops if valid
                if((Price[j] + Price[k]) == M) {
                    printf("%d %d\n", j+1, k+1);
                    j = N; break;
                }
            }
        }      
    }
    return 0;
}