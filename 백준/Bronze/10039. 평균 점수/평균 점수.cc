#include <iostream>

using namespace std;

int a;
int ans = 0;
int main() {
	for (int i = 0; i < 5; i++) {
		cin >> a;
		if (a < 40) a = 40;
		ans += a;
	}
	
	cout << ans / 5;


	return 0;
}