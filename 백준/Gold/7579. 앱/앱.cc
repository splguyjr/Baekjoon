#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
pair<int, int> cost_val[101];// 비용, 가치(확보 가능한 메모리의 양)의 순서로 저장
int dp[101][10001];//i번째 앱까지 고려했을때, j의 비용으로 확보할 수 있는 최대 메모리 공간
int min_cost = 10001;


int main() {
	
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		cin >> cost_val[i].second;
	}



	for (int i = 1; i <= n; i++) {
		cin >> cost_val[i].first;
	}

	sort(cost_val+1, cost_val + n+1);

	for (int i = 1; i <= n; i++) {
		int cost = cost_val[i].first;
		int val = cost_val[i].second;
		for (int j = 0; j < 10001; j++) {
			if(cost <= j) {
				dp[i][j] = max(dp[i - 1][j - cost] + val, dp[i - 1][j]);
			}
			else {
				dp[i][j] = dp[i - 1][j];
			}
		}
	}

	for (int i = 1; i <= 10001; i++) {
		if (dp[n][i] >= m) {
			cout << i;
			break;
		}
	}


	return 0;
}