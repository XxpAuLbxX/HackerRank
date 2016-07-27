#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, k, q, index;
    cin >> n >> k >> q;
    k %= n;
    int a[n];
    // create array 
    for(int i = 0; i < n; i++)
        cin >> a[i];
    // adjust array to be in bounds
    for(int i = 0; i < q; i++) {
        cin >> index;
        if(index-k >= 0) {
            cout << a[index-k] << endl;
        } else {
            cout << a[index-k+n] << endl;
        }
    }
    return 0;
}
