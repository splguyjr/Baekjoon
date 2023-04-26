#include <iostream>

using namespace std;

int n, f;

int main() {
	cin >> n >> f;

	n = n - n % 100;//100의자리 이상 

	while (n % f != 0) {
		n = n + 1;
	}

	int ans = n % 100;

	if (ans < 10) {
		cout << 0 << ans;
		return 0;
	}

	else {
		cout << ans;
	}



	return 0;
}