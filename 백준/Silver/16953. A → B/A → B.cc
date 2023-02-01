#include <iostream>
#include <algorithm>

using namespace std;

long a, b;
int ans = 1000000000;
void dfs(long num, int depth) {
	if (num > b) return;
	else if (num == b) {
		ans = min(ans,depth);
		return; }

	dfs(num *10+1, depth + 1);
	dfs(num * 2, depth + 1);
}
int main() {
	cin >> a >> b;
	
	dfs(a, 1);
	cout << ((ans == 1000000000) ? -1 : ans);
	return 0;
}