#include <iostream>

using namespace std;

int n;
int m;
int arr[2001];
int dp[2001][2001];


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		dp[i][i] = 1;
	
	}
	for (int i = 0; i < n-1; ++i) {
		if (arr[i] == arr[i + 1]) {
			dp[i][i + 1] = 1;
		}
	}

	// (0,2), (1,3) ...(n-3,n-1)
	// (0,3), (1,4) ...(n-4,n-1)
	// 크기가 x인 구간에 대해 팰린드롬 여부를 검사할때 x-2범위의 dp값이 필요(양끝 제외 가운데 부분).
	
	for (int i = 2; i < n; ++i) {
		for (int j = 0; i + j < n; ++j) {
			if (arr[j] == arr[i + j] && dp[j + 1][i + j - 1] == 1) {
				dp[j][i + j] = 1;
			}
		}
	}


	cin >> m;
	int x, y;
	
	
	for (int i = 0; i < m; ++i) {
		cin >> x >> y;
		cout << dp[x-1][y-1] << '\n';
		}
	

	return 0;
}