#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
long long k;
vector<long long> v;
long long t;
long long m=1000000000;
long long l;
long long r;
bool check;
long long ans;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;
	int temp;
	while (n--) {
		cin >> temp;
		m = m > temp ? temp : m;
		v.push_back(temp);}

	sort(v.begin(), v.end());
	l = m;
	r = m + k;
	while (l <= r) {
		long long comp = 0;
		long long mid = (l + r) / 2;
		//cout << mid << " " << l << " " <<r<< endl;
		for (int i = 0; i < v.size(); ++i) {
			if (mid > v[i] && mid - v[i] > 0) comp += mid - v[i];
		}
		if (comp > k) {
			r = mid - 1;
		}
		else {
			ans = mid;
			l = mid + 1;
		}
	}

	cout << ans;


}