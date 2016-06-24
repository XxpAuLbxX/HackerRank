#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, i = 0;
    cin >> n;
    int arr[n];
    while(cin >> arr[i]) { i++; }
    for( ; i > 0; i--) {
        cout << arr[i-1] << " ";
    }
    return 0;
}