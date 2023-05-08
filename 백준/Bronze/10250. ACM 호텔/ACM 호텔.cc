#include <iostream>

using namespace std;

int t;
int h, w, n;

int main() {
	cin >> t;

	while (t--) {
		cin >> h >> w >> n;

		int temp = n % h;
		if (n % h == 0) temp = h;
		
		cout << (n-1) / h + 1 + temp * 100  << '\n';
	}

	


	return 0;
}