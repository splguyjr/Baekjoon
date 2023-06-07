#include <iostream>
#include <algorithm>

using namespace std;

int ans = 0, cur = 0;

int main() {

	int a, b;
	for (int i = 0; i < 4; i++) {
		cin >> a >> b;
		cur += b;
		cur -= a;
		ans = max(ans, cur);
	}

	cout << ans;

	return 0;
}