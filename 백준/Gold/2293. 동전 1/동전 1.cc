#include <iostream>
#include <algorithm>
using namespace std;

int n, k;

int dp[10001];
int num[101];

int main() {
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}

	sort(num, num + n);

	dp[0] = 1;

	for (int i = 0; i < n; i++) {
		for (int j = num[i]; j <= k; j++) {
				
			dp[j] += dp[j-num[i]];
				
			
		}
	}

	cout << dp[k];
	return 0;
}