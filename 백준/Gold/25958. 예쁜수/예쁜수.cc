#include <iostream>
#include <algorithm>

using namespace std;

int m, k;
int cute[5001];
int dp[5001];

int cal(int n) {
	int sum = 0;

	while (n != 0) {
		int temp = n % 10;
		sum += temp;
		n /= 10;
	}

	return sum;
}

int main() {
	cin >> m >> k;

	for (int i = 1; i <= 5000; i++) {
		if (i % cal(i) == 0) {
			cute[i] = 1;
		}
	}
	
	

	fill(dp, dp + 5001, 1);

	for (int i = 2; i <= m; i++) {
		for (int j = 1; j <= m; j++) {
			if(cute[i] == 1) {
				if(j >= i) dp[j] = (dp[j] + dp[j - i]) % k;
			}
		}
	}

	cout << dp[m];

	return 0;
}