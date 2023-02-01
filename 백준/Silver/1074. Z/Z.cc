#include <iostream>

using namespace std;

int n, r, c;
int ans;

void z(int x, int y, int n) {
	if (x == r && y == c) {
		cout << ans << '\n';
		return;
		}

	if (r < x + n && r >= x && c < y + n && c >= y) {
		z(x, y, n / 2);
		z(x, y + n / 2, n / 2);
		z(x + n / 2, y, n / 2);
		z(x + n / 2, y + n / 2, n / 2);
	}

	else ans += n * n;
}


int main() {
	cin >> n >> r >> c;

	z(0, 0, 1 << n);


	return 0;
}