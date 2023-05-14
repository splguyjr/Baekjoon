#include <iostream>

using namespace std;

int n;

int main() {
	cin >> n;

	int num5 = 0;
	
	int temp = n;

	while (temp >= 5) {
		num5 += temp / 5;
		temp /= 5;
	}

	cout << num5;


	return 0;
}