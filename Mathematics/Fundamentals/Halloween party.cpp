#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int T;
    long K, length, width;
    cin >> T;
    // loop for each K 
    for(int i = 0; i < T; i++) {
        cin >> K;
        length = K/2; // approx optimal side
        width = K - length; // leftover for odd K
        cout << length * width << endl;
    }
    return 0;
}