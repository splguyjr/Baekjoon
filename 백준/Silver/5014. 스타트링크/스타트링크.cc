#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int f, s, g, u, d;
queue<int> q;
int visited[1000001];
int dx[2];

void bfs() {
	visited[s] = 1;
	q.push(s);

	while(!q.empty()) {
		int x = q.front();
		q.pop();
		
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];

			if (nx >= 1 && nx <= f) {
				if(!visited[nx]) {
					visited[nx] = visited[x] + 1;
					q.push(nx);
				}
			}
		}
	}
}

int main() {
	cin >> f >> s >> g >> u >> d;
	dx[0] = u;
	dx[1] = -d;
	bfs();
	
	if (visited[g])
		cout << visited[g] - 1;
	else cout << "use the stairs";

	return 0;
}