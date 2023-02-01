#include <iostream>
#include <algorithm>

using namespace std;

int d[1000001] = { -1,0 };
int n;

int main() {
	cin >> n;

	for (int i = 2; i <= n; ++i) {
		d[i] = d[i-1] + 1;

		if (i % 3 == 0)
			d[i] = min(d[i/3] + 1, d[i]);

		if (i % 2 == 0)
			d[i] = min(d[i/2] + 1, d[i]);

		

	}
	cout << d[n] << endl;

	while (n != 0) {
		cout << n << ' ';

		if (d[n] == d[n - 1] + 1) n = n - 1;

		else if (n % 2 == 0 && d[n] == d[n / 2] + 1) n = n / 2;

		else if (n % 3 == 0 && d[n] == d[n / 3] + 1) n = n / 3;
	}

}