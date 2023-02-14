#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int n, s;
vector<int> v;
long long ans;
map<int, int> m;


void dfs(int idx, int sum) {
	if (idx == n) {
		m[sum]++; return; 
	}
	dfs(idx + 1, sum);
	dfs(idx + 1, sum + v[idx]);
}




int main() {

	cin >> n >> s;

	v.resize(n);

	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	dfs(0, 0);

	ans += m[s];
	if (s == 0) ans--;
	cout << ans;





	return 0;
}
