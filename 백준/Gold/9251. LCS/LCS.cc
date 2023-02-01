#include <iostream>
#include <algorithm>

using namespace std;

int dp[1001][1001];
string x, y;


int main() {
	cin >> x >> y;
		
	for (int i = 0; i < x.size(); i++) {
		for (int j = 0; j < y.size(); j++) {
			if (x[i] == y[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
			}
			else {
				dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1]);
			}


		} 
	
	}

	cout << dp[x.size()][y.size()];
	



	return 0;
}