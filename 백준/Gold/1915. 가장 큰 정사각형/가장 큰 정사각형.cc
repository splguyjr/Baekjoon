#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int dp[1001][1001];
int ans = 0;

int main() {
	
	cin >> n >> m;

	string temp;
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		for (int j = 0; j < temp.length(); j++) {
			dp[i][j+1] = temp[j] - '0';
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if(dp[i][j] != 0) {
			dp[i][j] = min({ dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1] }) + 1;
			
			}
			if (ans < dp[i][j]) ans = dp[i][j];
		}
	}

	cout << ans * ans;


	return 0;
}