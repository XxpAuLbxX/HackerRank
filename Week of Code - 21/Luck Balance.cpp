#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N, K, luck = 0, i = 0, j;
    cin >> N >> K;
    int L[N], T[N], Lose[K] = {0};
    cout << Lose[0] << Lose[1];
    while(cin >> L[i] >> T[i]) {
        j = 1;
        if(T[i] == 0) {
            luck += L[i];
        } else if(Lose[0] < L[i]) {
            while(j < K) {
                if(Lose[j] < L[i]) {
                    Lose[j] = Lose[j-1]; // shift
                } else {
                    Lose[j-1] = L[i];
                    break;
                }
                j++;
            }
        }
        i++; 
    }
    i = 0;
    while(i < K) {
        luck += Lose[i];
        i++;
    }
    cout << luck;
    return 0;
}