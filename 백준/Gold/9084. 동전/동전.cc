#include <iostream>
#include <cstring>

using namespace std;

int t, n;
int sum;
int coin_sum[10001];
int coin[21];


int main() {
	cin >> t;

	while (t--) {
		memset(coin_sum, 0, sizeof(coin_sum));

		cin >> n;

		for (int i = 1; i <= n; i++) {
			cin >> coin[i];
		}
		
		cin >> sum;

		coin_sum[0] = 1;

		for(int i = 1; i<=n; i++) {
			for(int j = coin[i]; j<= sum; j++) {
				coin_sum[j] += coin_sum[j - coin[i]];
			}
		}

		cout << coin_sum[sum] << '\n';
	}



	return 0;
}