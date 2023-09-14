#include <iostream>

using namespace std;

int t;
int sav=0;
long long fibo[1000001];

int main() {
	cin >> t;
	
	int n;

	fibo[1] = 1;
	fibo[2] = 2;
	fibo[3] = 4;

	while (t--) {
		cin >> n;
		if (n <= 3) {
			cout << fibo[n] << '\n';
			continue;
		}

		if (sav < n) sav = n;

		else {
			cout << fibo[n] << '\n';
			continue;
		}

		

		for (int i = 4; i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2] + fibo[i - 3]) % 1000000009;
		}

		cout << fibo[n] << '\n';
	}

	return 0;
}