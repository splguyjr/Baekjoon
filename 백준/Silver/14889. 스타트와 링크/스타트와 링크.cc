#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int n;
int arr[21][21];
bool visited[21];
int ans = 2000;

void dfs(int cnt, int idx) {
	
	if (cnt == n / 2) {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i] && visited[j]) sum1 += arr[i][j];
				else if (!visited[i] && !visited[j]) sum2 += arr[i][j];
			}
		}

		ans = min(ans, abs(sum2 - sum1));
		return;
	}


	for (int i = idx; i < n; i++) {
		if(!visited[i]) {
		visited[i] = true;
		dfs(cnt + 1, i + 1);
		visited[i] = false;
		}
	}
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}

	dfs(0, 0);

	cout << ans;




	return 0;
}