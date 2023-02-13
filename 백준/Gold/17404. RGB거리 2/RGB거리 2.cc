#include <iostream>
#include <algorithm>

using namespace std;

int house[4][1001];
int dp[4][1001];
int n;
int ans = 1000000;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> house[1][i] >> house[2][i] >> house[3][i];
	}

	//1,2,3 = red, green, blue

	for(int color = 1; color<=3; color++) {
		
		for (int i = 1; i <= 3; i++) {
			if (i == color) dp[i][1] = house[i][1];
			else dp[i][1] = 1000000;
		}

	for (int i = 2; i <= n; i++) {

		dp[1][i] = house[1][i] + min(dp[2][i - 1], dp[3][i - 1]);
		dp[2][i] = house[2][i] + min(dp[1][i - 1], dp[3][i - 1]);
		dp[3][i] = house[3][i] + min(dp[1][i - 1], dp[2][i - 1]);
	}
	
	for (int i = 1; i <= 3; i++) {
		if (i == color) continue;
		ans = min(ans, dp[i][n]);
	}
	

	}

	cout << ans;


	return 0;
}