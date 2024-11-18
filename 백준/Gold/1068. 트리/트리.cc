#include <iostream>
#include <vector>

using namespace std;

int n, k, root, leaf;
vector<int> tree[51];//자식 노드 최대 2개(좌, 우) 저장

void dfs(int node) {
	if (node == k)
		return;
	
	if (tree[node].size() == 0) {
		leaf++;
		return;
	}

	if (tree[node].size() == 1 && tree[node][0] == k) {//자식이 하나인데 지워져야하는경우 부모노드가 리프노드가 됨
		leaf++;
		return;
	}

	else {
		for (int i = 0; i < tree[node].size(); i++) {
			int next = tree[node][i];
			if (next != k) {
				dfs(next);
			}
		}
	}


}


int main() {
	cin >> n;

	int x;

	for (int i = 0; i < n; i++) {
		cin >> x;
		if (x == -1) {
			root = i;
			continue;
		}
		else {
			tree[x].push_back(i);
		}
	}

	cin >> k;

	dfs(root);
	cout << leaf;

	return 0;
}