#include <iostream>
#include <algorithm>

using namespace std;

int n, s;
int num[100001];
int sum = 0;
int p1 = 0, p2 = 0, cnt = 0;
int ans=100000;

int main() {
	cin >> n >> s;
	
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}

	while (p2 <= n && ans != 1) {
		
		if (sum < s) {
			sum += num[p2];
			p2++; cnt++; continue;
		}
		else {
			ans = min(ans, cnt);
			sum -= num[p1];
			p1++; cnt--;
		}
	}

	if (ans == 100000) {
		cout << 0;
		return 0;
	}
	cout << ans;

	return 0;
}