#include <iostream>
#include <vector>

using namespace std;

vector<int> t;
vector<int> party[51];
int parent[51];
int n, m, numt;
int ans = 0;

int find(int x) {
	if (parent[x] == x) return x;
	else return find(parent[x]);
}

void Union(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return;
	parent[y] = x;
}

int main() {

	cin >> n >> m;
	cin >> numt;

	int temp;

	for (int i = 1; i <= numt; i++) {
		cin >> temp;
		t.push_back(temp);
	}

	for (int cnt, i = 1; i <= m; i++) {
		cin >> cnt;
		for (int j = 1; j <= cnt; j++) {
			cin >> temp;
			party[i].push_back(temp);
		}
	}

	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}

	for (int i = 1; i <= m; i++) {
		int first = party[i][0];
		for (int j = 1; j < party[i].size(); j++) {
			Union(first, party[i][j]);
		}
	}

	for (int i = 1; i <= m; i++) {
		bool b = true;
		int first = party[i][0];
		for (int j = 0; j < t.size(); j++) {
			if (find(first) == find(t[j])) {
				b = false;
				break;
			}
		}
		if (b) ans++;
	}

	cout << ans;
	return 0;
}