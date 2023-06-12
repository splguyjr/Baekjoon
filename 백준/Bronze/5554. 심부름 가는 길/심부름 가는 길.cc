#include <iostream>

using namespace std;

int x, y;
int sum = 0;

int main() {

	for (int i = 0; i < 4; i++) {
		cin >> x;
		sum += x;
	}

	x = sum / 60;
	y = sum % 60;

	cout << x << '\n' << y;


	return 0;
}