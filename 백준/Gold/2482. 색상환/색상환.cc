#include <iostream>
#include <cstring>

using namespace std;

int n, k;
int dp[1001][1001];


int color(int n, int k) {
	
	if (n / 2 < k) return dp[n][k] = 0;
	if (k == 1) return dp[n][k] = n;

	if (dp[n][k] == -1) {
		return dp[n][k] = (color(n - 2, k - 1) + color(n - 1, k)) % 1000000003;
	}
	else return dp[n][k];
}

int main() {
	cin >> n >> k;
	memset(dp, -1, sizeof(dp));
	

	cout << color(n, k);;

	return 0;

}

//https://source-sc.tistory.com/5참고