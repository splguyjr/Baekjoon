#include <iostream>

using namespace std;

char a;
int ans = 0;

int main() {

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			cin >> a;
			int check = i % 2 + j % 2;

			if (check == 0 || check == 2) {
				if (a == 'F') {
					ans++;
				}
			}
		}
	}

	cout << ans;



	return 0;
}