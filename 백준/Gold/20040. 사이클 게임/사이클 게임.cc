#include <iostream>

using namespace std;

int n, m;
int graph[500001];
int getParent(int parent[], int x) {
	if (parent[x] == x) return x;
	return parent[x] = getParent(parent, parent[x]);
}

void unionParent(int parent[], int a, int b) {
	a = getParent(parent, a);
	b = getParent(parent, b);
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

int findParent(int parent[], int a, int b) {
	a = getParent(parent, a);
	b = getParent(parent, b);
	if (a == b) return 1;
	else return 0;
}

int main() {
	cin >> n >> m;
	int a, b;

	for (int i = 0; i < n; i++) {
		graph[i] = i;
	}

	for(int i =0; i<m; i++) {
		cin >> a >> b;
		if (findParent(graph, a, b)) {
			cout << i + 1;
			return 0;
		}
		unionParent(graph, a, b);
	}
	cout << 0;

	return 0;
}