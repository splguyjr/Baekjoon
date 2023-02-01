#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int temp = i;
		int temp2 = n - temp;
		while (temp2--)cout << ' ';
		while (temp--) cout << "*";
		cout << '\n';
	}
}