#include <iostream>

using namespace std;

int n;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int x = 0;
		for (int j = 1; j <= n; j++) {
			int tmp;
			cin >> tmp;
			x = x | tmp;
		}
		cout << x << " ";
	}


	return 0;
}