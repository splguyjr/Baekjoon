#include <iostream>
#include <cmath>

using namespace std;

int n;
int dp[31][15001];
int w[31];
int check_num;

void solve(int cnt, int total) {
	if (cnt > n || dp[cnt][total]) return;

	dp[cnt][total] = 1;

	solve(cnt + 1, abs(total - w[cnt]));
	solve(cnt + 1, total);
	solve(cnt + 1, total + w[cnt]);
	
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> w[i];
	}

	solve(0, 0);

	cin >> check_num;
	
	for (int i = 1; i <= check_num; i++) {
		int x;
		cin >> x;

		if (x > 15000) {
			cout << "N ";
		}
		else if (dp[n][x]) cout << "Y ";

		else cout << "N ";
	}

	return 0;
}

