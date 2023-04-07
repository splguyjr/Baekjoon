#include <iostream>

using namespace std;

int n;
int dp[1001][10];//dp[i][j]: i개짜리 오르막수 중 끝이 j인 경우
int ans = 0;

int main() {
	
	cin >> n;

	for (int i = 0; i < 10; i++) {
		dp[1][i] = 1;
	}

	
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j < 10; j++) {//오르막 수의 끝은 0~9까지 가능
			for (int k = 0; k <= j; k++) {//i-1개짜리 오르막수 중, 끝이 0~j까지인것을 다 더해줌
				dp[i][j] += dp[i - 1][k] % 10007;
			}
		}
	}

	for (int i = 0; i < 10; i++) {
		ans += dp[n][i];
	}

	cout << ans % 10007;



	return 0;
}