#include <iostream>
#include <cstring>

using namespace std;

int n;
const int mod = 1e9;
int stair[10][101];
int ans = 0;

//digit으로 시작하는 length길이에 대하여 계단수의 갯수를 return
int dp(int digit, int length) {
	if (digit < 0 || digit >9) return 0;

	int& res = stair[digit][length];

	if (res != -1) return res;
	else {
		res = (dp(digit - 1, length - 1) + dp(digit + 1, length - 1)) % mod;
		return res;
	}
}


int main() {
	cin >> n;

	memset(stair, -1, sizeof(stair));

	for (int i = 0; i < 10; i++) {
		stair[i][1] = 1;
	}

	for (int i = 1; i < 10; i++) // 첫 시작은 1~9만 가능.
	{
		ans += dp(i, n);
		ans %= mod;
	}

	cout << ans << endl;

	return 0;
}

//https://jaimemin.tistory.com/359?category=988050 참고 top-down 방식으로 깔끔하게 짜인 코드