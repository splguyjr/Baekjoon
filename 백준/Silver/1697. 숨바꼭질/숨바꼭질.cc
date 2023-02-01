#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visited[200001];
queue<pair<int, int>> q;
int n, k;


int bfs(pair<int, int> p) {
	q.push(p);
	visited[p.first] = true;

	while(!q.empty()) {
		int a = q.front().first;
		int b = q.front().second;
		q.pop();

		if (a <0 || a > 100000) continue;
		if (a == k) return b;
		
		if(!visited[a - 1]) {
			visited[a - 1] = true;
			q.push({ a - 1, b + 1 });
		}

		if (!visited[a + 1]) {
			visited[a + 1] = true;
			q.push({ a + 1, b + 1 });
		}

		if (!visited[2 * a]) {
			visited[2 * a] = true;
			q.push({ 2 * a , b + 1 });
		}
	

	}
}

int main() {
	cin >> n >> k;

	cout << bfs({ n,0 });

}