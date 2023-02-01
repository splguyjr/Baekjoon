#include <iostream>
#include <cmath>

using namespace std;

int n;
int ans;
int dp[50001];



int main() {
	cin >> n;
	dp[0] = 0;
	dp[1] = 1;

	int count = 0;
	int min = 50000;

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= sqrt(i); j++) {
			int temp = i - pow(j, 2);
		
			if(min >dp[temp] + 1) min = dp[temp] + 1;
			}
		dp[i] = min;

		min = 50000;
	}

	cout << dp[n];

}