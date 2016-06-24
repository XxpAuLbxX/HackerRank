#include <iostream>
#include <string>
using namespace std;

int main() {
    string a, b, c;
    cin >> a >> b;
    cout << a.length() << " " << b.length() << endl;
    cout << a+b << endl;
    c = a;
    a[0] = b[0];
    b[0] = c[0];
    cout << a << " " << b;
    return 0;
}