#include <iostream>
#include <cstring>

using namespace std;

int n;
const int mod = 1e9;
int stair[10][101][1 << 10];
int ans = 0;

int dp(int start, int length, int num_used) {
	if (length == n) {
		return num_used == (1 << 10) - 1 ? 1 : 0;
	}

	int& res = stair[start][length][num_used];

	if (res != -1)
		return res;

	res = 0;

	if (start + 1 < 10) res += dp(start + 1, length + 1, num_used | 1 << start + 1);
	if (start - 1 >= 0) res += dp(start - 1, length + 1, num_used | 1 << start - 1);

	res %= mod;

	return res;
}


int main() {

	cin >> n;

	for (int i = 1; i <= 9; i++) {
		memset(stair, -1, sizeof(stair));
		ans += dp(i, 1, 1 << i); // 시작은 1부터, 1<<i로 넘겨줘서 사용여부확인하도록
		ans %= mod;
	}

	cout << ans;

	return 0;
}