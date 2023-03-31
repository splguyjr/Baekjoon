#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr_sum[50001];
int dp[4][50001];
int m;//끌 수 있는 최대 객차 수

int main() {
	cin >> n;
	
	int tmp;
	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		arr_sum[i] = arr_sum[i - 1] + tmp;
	}

	cin >> m;
	for (int i = 1; i <= 3; i++) {
		for (int j = i * m; j <= n; j++) {
			dp[i][j] = max(dp[i - 1][j - m] + arr_sum[j] - arr_sum[j - m], dp[i][j - 1]);
		}
	}
	


	cout << dp[3][n];

	return 0;

}