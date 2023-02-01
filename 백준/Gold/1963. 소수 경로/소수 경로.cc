#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

bool prime[10000];//false여야 소수
bool visited[10000];



void prim() {
	prime[1] = true;
	for (int i = 2; i < 101; ++i) {
		if (prime[i]) continue;

			for (int j = i * 2; j < 10000; j+=i) {
				if (!prime[j]) prime[j] = true;
			}
	}
}

int bfs(int cur, int end) {
	queue<pair<int, int>> q;
	q.push({ cur,0 });
	visited[cur] = true;

	while (!q.empty()) {
		int a = q.front().first;
		int b = q.front().second;
		q.pop();

		if (a == end) return b;

		for (int i = 0; i < 4; ++i) {
			int temp;

			switch (i) {
			case 0:
				for (int j = 1; j <= 9; ++j) {// 1000의자리숫자는 0이되면 안됨
					temp = (j * 1000 + a % 1000);
					if (!visited[temp] && !prime[temp]) {
						visited[temp] = true;
						q.push({ temp, b + 1 });
					}
				}
				break;
			case 1:
				for (int j = 0; j <= 9; ++j) {
					temp = (j * 100 + (a/1000*1000) + (a % 100));
					if (!visited[temp] && !prime[temp]) {
						visited[temp] = true;
						q.push({ temp, b + 1 });
					}
				}
				break;
			case 2:
				for (int j = 0; j <= 9; ++j) {
					temp = (j * 10 + (a / 100 * 100)+ (a % 10));
					if (!visited[temp] && !prime[temp]) {
						visited[temp] = true;
						q.push({ temp, b + 1 });
					}
				}
				break;
			case 3:
				for (int j = 0; j <= 9; ++j) {
					temp = (j + (a /10*10));
					if (!visited[temp] && !prime[temp]) {
						visited[temp] = true;
						q.push({ temp, b + 1 });
					}
				}
			}
		}
	}
	return -1;
}

int main() {
	int n;
	cin >> n;

	prim();

	while (n--) {
		memset(visited, false, sizeof(visited));
		int c, d;
		cin >> c >> d;
		int ans = bfs(c, d);
		if (ans == -1) cout << "Impossible" << '\n';
		else cout << ans << '\n';
	}
}