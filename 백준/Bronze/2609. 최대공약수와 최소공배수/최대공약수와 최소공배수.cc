#include <iostream>

using namespace std;

int main() {
	int a, b, max, temp;

	cin >> a >> b;
	max = a * b;
	while (a % b != 0) {
		temp = a % b;
		a = b;
		b = temp;
	}
	cout << b << '\n';

	cout << max / b;
}