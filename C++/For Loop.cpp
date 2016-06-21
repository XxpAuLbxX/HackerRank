#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

int main() {
    int a, b;
    string numbers[9] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    cin >> a;
    cin >> b;
    for(int i = a-1; i<b; i++) {
        if(i<9) {
            cout << numbers[i] << endl;
        } else {
            if((i+1)%2 == 0) {
                cout << "even\n";
            } else {
                cout << "odd\n";
            }
        }
    } 
    return 0;
}