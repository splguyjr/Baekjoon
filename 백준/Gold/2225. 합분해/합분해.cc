#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n,k;
	int dp[201][201];//[n][k]
	
	cin>> n>>k;
	//k개를 더해서 n
	
	for(int i =1; i<=k; i++) {
		dp[0][i]=1;
	}
	
	for(int i =1;i<=n; i++) {
		for(int j =1; j<=k; j++) {
			dp[i][j] = (dp[i-1][j]+ dp[i][j-1])% 1000000000;
		}
	}
	
	cout <<dp[n][k];
	return 0;
}