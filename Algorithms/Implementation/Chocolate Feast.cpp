#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int t, wrappers, choc;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        int n; // Total money
        int c; // Cost
        int m; // Exchange number
        cin >> n >> c >> m;
        n = n / c; // Number of chocolates
        wrappers = n; // Number of wrappers
        while(wrappers >= m) {
            choc = wrappers / m; // Chocolates from wrappers
            n += choc; // New chocolates added to total
            c = wrappers % m; // Wrappers left over
            wrappers = choc + c; // New wrapper total
        }
        cout << n << endl;
    }
    return 0;
}