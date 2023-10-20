#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int t;
int d[10] = { 2,5,5,4,5,6,3,7,6,6 };
long long dp[101] = { 0, 0, 1, 7, 4, 2, 6, 8, 10};

void print_min(int n) {
	cout << dp[n];

	return;
}

void print_max(int n) {
	string x;
	if (n % 2) {
		x += "7";
		n -= 3;
		while (n) {
			x += "1";
			n -= 2;
		}
		cout << x;
		return;
	}

	else {
		while (n) {
			x += "1";
			n -= 2;
		}
		cout << x;
		return;

	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	int n;

	for (int i = 9; i <= 100; i++) {
		long long temp = 1e16;
		for (int j = 2; j <= 7; j++) {
			if (j == 2) { temp = min(temp, dp[i - j] * 10 + 1); }
			else if (j == 3) { temp = min(temp, dp[i - j] * 10 + 7); }
			else if (j == 4) { temp = min(temp, dp[i - j] * 10 + 4); }
			else if (j == 5) { temp = min(temp, dp[i - j] * 10 + 2); }
			else if (j == 6) { temp = min(temp, dp[i - j] * 10 + 0); }
			else if (j == 7) { temp = min(temp, dp[i - j] * 10 + 8); }
		}
		dp[i] = temp;
	}

	while (t--) {
		cin >> n;
		print_min(n);
		cout << " ";
		print_max(n);
		cout << '\n';
	}


	return 0;
}