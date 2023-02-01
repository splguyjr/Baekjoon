#include <iostream>

using namespace std;

int main() {
	int n;
	int temp = 5;
	int ans = 0;
	while (temp--) {
		cin >> n;
		ans += n * n;
	}

	ans %= 10;
	cout << ans;

}