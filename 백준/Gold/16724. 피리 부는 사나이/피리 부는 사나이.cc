#include <iostream>

using namespace std;

int map[1001][1001];
int visited[1001][1001];
int n, m;
int cycle= 0;

void dfs(int x, int y) {
	if (visited[x][y] == 2) return;
	if (visited[x][y] == 1) { visited[x][y] = 2; cycle++; return; }
	visited[x][y] = 1;
	if (map[x][y] == 0) { dfs(x, y - 1); }
	else if (map[x][y] == 1) { dfs(x - 1, y);}
	else if (map[x][y] == 2) { dfs(x + 1, y);}
	else if (map[x][y] == 3) { dfs(x, y + 1);}
	visited[x][y] = 2;
}

int main() {
	cin >> n >> m;

	char temp;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> temp;
			if (temp == 'U') map[i][j] = 1;
			else if(temp == 'D') map[i][j] = 2;
			else if (temp == 'R') map[i][j] = 3;
		}
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (!visited[i][j]) dfs(i, j);
		}
	}

	cout << cycle;

	return 0;
}