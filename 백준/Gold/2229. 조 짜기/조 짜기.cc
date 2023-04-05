#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[1001];
int arr[1001];

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	for (int i = 2; i <= n; i++) {
		int x = arr[i], y = arr[i];
		for (int j = i; j >= 1; j--) {//i번째부터 i-1방향으로 하나씩 더 포함해가며 최대 최소 도출
			x = max(x, arr[j]);
			y = min(y, arr[j]);
			dp[i] = max(dp[i], dp[j-1] + x - y);
		}
	}

	cout << dp[n];

	return 0;
}

//https://leesh111112.tistory.com/367 참고