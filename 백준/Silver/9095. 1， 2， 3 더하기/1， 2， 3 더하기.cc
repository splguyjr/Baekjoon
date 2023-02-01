#include <iostream>
using namespace std;

int main() {
	int num;
	cin >> num;
	while(num--) {
	int dp[11] = {0,1,2,4};
	int n;
	cin >> n;
	if(n<=3) {
		cout << dp[n]<<endl;
	}
	else {
	for(int i =4; i<=n; i++) 
	{dp[i] = dp[i-1] + dp[i-2] + dp[i-3];}
	
	cout << dp[n]<<'\n';}
	}
	return 0;
}