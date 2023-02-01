#include <iostream>
#include <algorithm>

using namespace std;

int n,k;
int coin[101];
int dp[10001]={0};


int main() {
	cin >> n >> k;
	
	for(int i = 1; i<=k; i++) {
		dp[i] = 10001; //최대로 초기화
	}
	
	int temp;
	
	for(int i =1; i <= n; i++) {
		cin >> temp;
		coin[i] = temp; //coin[1]부터 차례대로 동전 값 넣기
	}
	
	for(int i =1; i<=n; i++) {
		for(int j=coin[i]; j<=k; j++) {
			dp[j] = min(dp[j], dp[j-coin[i]]+1);
		}
	}
	
	if(dp[k] == 10001) {
		cout << "-1";
		return 0;
	}
	
	cout <<dp[k];
	
	return 0;
}