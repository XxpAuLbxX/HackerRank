#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int a0; 
    int a1; 
    int a2; 
    scanf("%d %d %d",&a0,&a1,&a2);
    int b0; 
    int b1; 
    int b2; 
    scanf("%d %d %d",&b0,&b1,&b2);
    int scoreA, scoreB;
    scoreA = (a0 > b0) + (a1 > b1) + (a2 > b2);
    scoreB = (b0 > a0) + (b1 > a1) + (b2 > a2);
    printf("%d %d", scoreA, scoreB);
    return 0;
}
