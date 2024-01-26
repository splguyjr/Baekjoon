#include <iostream>

using namespace std;

int n, k;

int main() {
	cin >> n >> k;

	if (k >= n) {
		cout << "Impossible";
		return 0;
	}

	else {
		int x = n - k;
		int idx = 1;
		
		if (x % 2 == 1) {
			cout << 1 << " ";
			x--;
			idx++;
		}

		for (int i = idx; i <= n; i++) {
			if (x > 0) {
				cout << i + 1 << " " << i << " ";
				x -= 2;
				i++;
			}
			else cout << i << " ";
		}
	} 


	return 0;
}