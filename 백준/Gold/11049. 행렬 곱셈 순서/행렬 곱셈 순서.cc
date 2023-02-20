#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
int arr[502];
int mx_dp[502][502];


// 5 2 3 6
// 52 23 36  
// 23 36

int dp(int a, int b) {
	if (mx_dp[a][b] != 0) return mx_dp[a][b];
	if (a == b) return 0;

	int temp;

	for (int i = a; i <= b-1; i++) {
		temp = dp(a, i) + dp(i + 1, b) + arr[a - 1] * arr[i] * arr[b];
		if(mx_dp[a][b] == 0) mx_dp[a][b] = pow(2, 31)-1;
		mx_dp[a][b] = min(mx_dp[a][b], temp);
		
	}

	return mx_dp[a][b];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> n;
	int r, c;

	for (int i = 0; i < n; i++) {
		cin >> arr[i] >> arr[i + 1];

	}

	cout << dp(1, n);

	return 0;
}