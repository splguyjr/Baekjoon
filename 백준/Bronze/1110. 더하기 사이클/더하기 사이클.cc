#include <iostream>

using namespace std;

int n;
int cnt = 0;

int main() {
	cin >> n;
	
	int temp = n;
	int a, b, c = -1;

	while (c != n) {
		a = temp % 10;
		b = (temp % 10 + temp / 10) % 10;
		c = a * 10 + b;
		temp = c;
		cnt++;
	}

	cout << cnt;

	return 0;
}