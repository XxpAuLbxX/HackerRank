#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N, K, luck = 0, i = 0, j, count = 0;
    cin >> N >> K;
    int L[N], T[N], Lose[K] = {0};
    while(cin >> L[i] >> T[i]) {
        j = 1;
        // if unimportant, automatically lose for luck
        if(T[i] == 0) {
            luck += L[i];
        // Lose arr has lowest value at front, compare and swap in loop
        } else if((Lose[0] < L[i]) && (K != 0)) {
            // if array is full, first value must be dropped
            if(count >= K)
                luck -= Lose[0];
            while(j < K) {
                if(Lose[j] < L[i]) {
                    Lose[j-1] = Lose[j]; // shift to front
                    // if largest value
                    if(j == K-1) {
                        Lose[K-1] = L[i];  
                    }
                } else {
                    Lose[j-1] = L[i]; // insert value and quit
                    break;
                }
                j++;
            }
            count++;
        }
        i++; 
    }
    i = 0;
    // Add luck from highest skippable contests
    while(i < K) {
        luck += Lose[i];
        i++;
    }
    cout << luck;
    return 0;
}