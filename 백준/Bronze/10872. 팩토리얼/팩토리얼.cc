#include <iostream>

using namespace std;

int main() {
	int a;
	cin >> a;
	int fac = 1;
	while (a > 1) {
		fac = fac * a;
		a = a - 1;
	}
	cout << fac;
}