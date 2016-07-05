#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n1, height1 = 0; 
    int n2, height2 = 0; 
    int n3, height3 = 0; 
    int minTower;
    scanf("%d %d %d",&n1,&n2,&n3);
    int *h1 = malloc(sizeof(int) * n1);
    for(int h1_i = 0; h1_i < n1; h1_i++){
        scanf("%d",&h1[h1_i]);
        height1 += h1[h1_i];
    }
    
    int *h2 = malloc(sizeof(int) * n2);
    for(int h2_i = 0; h2_i < n2; h2_i++){
        scanf("%d",&h2[h2_i]);
        height2 += h2[h2_i];
    }
    int *h3 = malloc(sizeof(int) * n3);
    for(int h3_i = 0; h3_i < n3; h3_i++){
        scanf("%d",&h3[h3_i]);
        height3 += h3[h3_i];
    }
    if(height1 < height2) {
        if(height1 < height3) 
            minTower = height1;
        else
            minTower = height3;
    else {
        if(height2 < height3) 
            minTower = height2;
        else 
            minTower = height3;
        }
    }
    while (!(height1 == height2 == height3)) {
        
    }
    return 0;
}