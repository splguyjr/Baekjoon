#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int f, s, g, u, d;
int visit_cnt[1000001];
int ans = 1000000;

void dfs(int n, int cnt) {
	if (n == g) {
		ans = min(ans, cnt);
		return;
	}

	if (n > f || n < 1) return;

	if (visit_cnt[n] > cnt) {
		visit_cnt[n] = cnt;
		dfs(n + u, cnt + 1);
		dfs(n - d, cnt + 1);
	}

	return;
}

int main() {
	cin >> f >> s >> g >> u >> d;

	memset(visit_cnt, 1000000, sizeof(visit_cnt));
	dfs(s, 0);//1층 시작

	if (ans != 1000000) cout << ans;
	else cout << "use the stairs";

	return 0;
}