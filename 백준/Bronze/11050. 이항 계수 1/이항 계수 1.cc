#include <iostream>

using namespace std;

int n, k;

int main() {
	cin >> n >> k;
	
	
	int a = 1;
	int b = 1;

	while (k) {
		a *= n;
		b *= k;
		n--;
		k--;
	}

	cout << a / b;

	return 0;
}