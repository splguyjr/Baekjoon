#include <iostream>

using namespace std;

int n, m;
int lst[9];
bool visited[9];

void dfs(int count) {
	if (count == m) {
		for (int i = 0; i < m; i++) {
			cout << lst[i] << " ";
		}
		cout << '\n';
        return;
	}

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			lst[count] = i;
			dfs(count + 1);
			visited[i] = false;
		}
	}
}
	

int main() {
	cin >> n >> m;
	dfs(0);


	return 0;
}