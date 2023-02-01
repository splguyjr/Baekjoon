#include <iostream>

using namespace std;

int main() {

	int a;
	cin >> a;
	int n = 1;
	while (a > 0) {
		cout << n << '\n';
		a = a - 1;
		n++;
	}

}