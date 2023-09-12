#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> v;
vector<int> dist;
int ans = 0;

int gc(int a, int b) {
	int c = a % b;

	while (c != 0) {
		a = b;
		b = c;
		c = a % b;
	}
	
	return b;
}


int main() {
	cin >> n;

	int temp;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}

	for (int i = 1; i < n; i++) {
		dist.push_back(v[i] - v[i - 1]);
	}
	int gcd = dist[0];
	
	for (int i = 1; i < n - 1; i++) {
		gcd = gc(gcd, dist[i]);
	}

	ans = (v[n - 1] - v[0]) / gcd;
	ans -= n-1;

	cout << ans;

	return 0;
}