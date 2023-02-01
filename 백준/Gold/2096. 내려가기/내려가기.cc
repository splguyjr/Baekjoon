#include <iostream>
#include <algorithm>

using namespace std;

int n;
int score[3];
int max_dp[3];
int min_dp[3];

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> score[0] >> score[1] >> score[2];
		int temp0 = max_dp[0];
		int temp2 = max_dp[2];

		max_dp[0] = score[0] + max(max_dp[0], max_dp[1]);
		max_dp[2] = score[2] + max(max_dp[1], max_dp[2]);
		max_dp[1] = score[1] + max({ temp0, max_dp[1],temp2 });
		
		
		temp0 = min_dp[0];
		temp2 = min_dp[2];

		min_dp[0] = score[0] + min(min_dp[0], min_dp[1]);
		min_dp[2] = score[2] + min(min_dp[1], min_dp[2]);
		min_dp[1] = score[1] + min({ temp0, min_dp[1],temp2 });

	}

	cout << max({ max_dp[0],max_dp[1] ,max_dp[2] }) << " " << min({ min_dp[0],min_dp[1] ,min_dp[2] });


	return 0;
}