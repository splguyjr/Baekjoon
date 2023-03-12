#include <iostream>
#include <vector>
#include <cmath>
#include <cstring>

using namespace std;

vector<int> v;
int n;
int dp[5][5][100001];

int cal(int start, int end) {
	if (start == 0) return 2;
	else if (start == end) return 1;
	else if (abs(end - start) == 2) return 4;
	else return 3;

}

int dfs(int x, int y, int idx) {
	if (idx == n) return 0;
	if (dp[x][y][idx]) return dp[x][y][idx];

	int left = dfs(v[idx], y, idx + 1) + cal(x, v[idx]);

	int right = dfs(x, v[idx], idx + 1) + cal(y, v[idx]);
	
	return dp[x][y][idx] = min(left, right);
	
}

int main() {
	int num;

	while (true) {
		cin >> num;
		if (num == 0) break;
		v.push_back(num);
	}

	
	n = v.size();
	cout << dfs(0, 0, 0);

	return 0;
}