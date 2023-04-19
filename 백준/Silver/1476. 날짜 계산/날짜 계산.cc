#include <iostream>

using namespace std;

int e, s, m;//15, 28, 19
int ans = 1;

int main() {
	cin >> e >> s >> m;

	int a = 1, b = 1, c = 1;

	while (true) {
		if (a == 16) {
			a = 1;
		}
		if (b == 29) {
			b = 1;
		}
		if (c == 20) {
			c = 1;
		}
		if (a == e && b == s && c == m) {
			cout << ans;
			return 0;
		}
		
		a++; b++; c++; ans++;
	}
	

	return 0;
}