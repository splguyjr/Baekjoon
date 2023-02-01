#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;

	if (n == 4 || n == 7) {
		cout << -1;
		return 0;
	}

	int cnt = 0;

	while (n % 5 != 0) {
		n -= 3;
		cnt += 1;
	}
	cnt += (n / 5);

	cout << cnt;


	return 0;
}