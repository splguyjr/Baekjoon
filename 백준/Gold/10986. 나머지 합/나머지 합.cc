#include <iostream>

using namespace std;

int dp[1000001];//1부터 index까지의 구간합을 m으로 나눈 나머지를 저장
int arr[1001];//0~m-1의 나머지가 각각 몇 번 나왔는지를 저장하는 배열
int n, m;
long long ans = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> n >> m;

	int tmp;

	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		dp[i] = (dp[i-1] + tmp) % m;
		arr[dp[i]]++;
	}

	for (int i = 0; i < m; i++) {
		if (arr[i] >= 2) {
			ans += ((long long)arr[i] * (arr[i] - 1)) / 2;
		}
	}


	cout << ans + arr[0];

	return 0;
}