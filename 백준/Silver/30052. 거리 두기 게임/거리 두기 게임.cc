#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int board[401][401];
int n, m, d;
int cnt = 0;

int abs_d(int a, int b, int c, int d) {
	return (abs(a - b) + abs(c - d));
}

int cal_d(int x, int y) {
	int mx = max(
		{ abs_d(x,1,y,1),abs_d(x,n,y,1) ,abs_d(x,1,y,m) ,abs_d(x,n,y,m) });
	return mx;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m >> d;

	

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (cal_d(i, j) >= d) { cnt++; }
		}
	}

	cout << n*m - cnt;

	return 0;
}