#include <iostream>

using namespace std;

int l, p;

int main() {

	cin >> l >> p;
	p = l * p;
	for (int i = 0; i < 5; i++) {
		cin >> l;
		cout << l - p << ' ';
	}



	return 0;
}