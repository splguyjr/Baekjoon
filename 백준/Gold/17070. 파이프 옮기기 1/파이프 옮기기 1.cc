#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int arr[17][17];
int dp[17][17][4];//가로 1, 세로 2, 대각선 3
int n;

int main() {
	cin >> n;

	int x;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
		}
	}

	dp[1][2][1] = 1; //초기
	//가로 1, 세로 2, 대각선 3
	for (int i = 1; i <= n; i++) {
		for (int j = 3; j <= n; j++) {
			if (!arr[i][j]) {
				dp[i][j][2] = dp[i - 1][j][2] + dp[i - 1][j][3];
				dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][3];
				if (!(arr[i - 1][j] || arr[i][j - 1])) {
					dp[i][j][3] = dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2] + dp[i - 1][j - 1][3];
				}
			}
		}
	}

	//for (int i = 1; i <= n; i++) {
	//	for (int j = 3; j <= n; j++) {
	//		cout << dp[i][j][1] + dp[i][j][2] + dp[i][j][3] << " ";
	//	}
	//	cout << endl;
	//}

	cout << dp[n][n][1] + dp[n][n][2] + dp[n][n][3];

	return 0;
}