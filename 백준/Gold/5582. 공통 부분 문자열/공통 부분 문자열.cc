#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string a, b;
int dp[4001][4001];
int ans = 0;

int main() {
	cin >> a >> b;


	for (int i = 0; i < a.size(); i++) {
		for (int j = 0; j < b.size(); j++) {
			if (a[i] == b[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
				if (ans < dp[i + 1][j + 1]) ans = dp[i + 1][j + 1];
			}
			else {
				dp[i + 1][j + 1] = 0;
			}
		}
	}

	cout << ans;

	return 0;

}