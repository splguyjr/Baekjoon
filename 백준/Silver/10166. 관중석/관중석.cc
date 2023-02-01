#include <iostream>
using namespace std;

int gcd(int a, int b) {
	int c = a % b;
	while (c != 0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}

int seat[2001][2001];

int main() {
	int d1, d2;
	cin >> d1 >> d2;

	int count = 0;

	for (int i = d1; i <= d2; i++) {
	
		for (int j = 1; j <= i; j++) {
			int s = gcd(i, j);
			int D1 = i / s;
			int D2 = j / s;

			if (seat[D1][D2] == 0) {
				seat[D1][D2] = 1; count++;
			}

		}

		cout << count;
		
	}
	return 0;
}