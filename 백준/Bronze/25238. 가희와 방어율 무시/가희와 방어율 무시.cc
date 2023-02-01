#include <iostream>

using namespace std;

int main() {
	double a, b;

	cin >> a >> b;
	if (a - (a * b / 100) >= 100) {
		cout << "0";
		return 0;
	}

	cout << "1";


	return 0;
}