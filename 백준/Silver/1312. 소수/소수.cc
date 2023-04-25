#include <iostream>

using namespace std;


int a, b, n;
int ans = 0;

int main() {
	cin >> a >> b >> n;
	
	if (a % b == 0) {
		cout << 0;
		return 0;
	}

	if (a > b) {
		a %= b;
	}

	for (int i = 0; i < n; i++) {
		a *= 10;
		ans = a / b;
		a %= b;
	}

	cout << ans;


	return 0;
}