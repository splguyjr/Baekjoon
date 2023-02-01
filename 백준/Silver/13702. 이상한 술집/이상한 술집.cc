#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int n, k;
int mak[10001];
long long l = 1;
int r = 0;
int mx = 0;
int ans = 0;
int main() {
	cin >> n >> k;

	for (int i = 0; i < n; ++i) {
		cin >> mak[i];
		if (mx < mak[i]) mx = mak[i];
	}
	r = mx;
	while (l <= r) {
		int mid = (r + l) / 2;
		int count = 0;
		for (int i = 0; i < n; ++i) {
			 count += mak[i] / mid;
		}
		if (count >= k) {
			l = mid + 1;
			ans = mid;
		}
		else r = mid-1;
	}
	
	cout << ans;

}