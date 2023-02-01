#include <iostream>

using namespace std;

int coin[11];

int main() {
	int n, k;
	cin >> n >> k;

	int ans = 0;


	for(int i= 0; i<n; i++) {
		cin >> coin[i];
	}


	for (int i = n-1; i >=0; i--) {
		
		ans += k / coin[i];
		k = k % coin[i];
		
	}

	cout << ans;

	return 0;
}