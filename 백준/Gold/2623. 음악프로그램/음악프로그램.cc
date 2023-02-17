#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int group_size[1001];
vector<int> v[1001];
vector<int> seq;

void topologySort() {
	queue<int> q;
	
	for (int i = 1; i <= n; i++) {
		if (group_size[i] == 0) q.push(i);
	}
	
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		seq.push_back(x);
		
		for (int i = 0; i < v[x].size(); i++) {
			group_size[v[x][i]]--;
			if (group_size[v[x][i]] == 0) q.push(v[x][i]);
		}
	}
}

int main() {
	cin >> n >> m;

	
	int cnt;
	for (int i=0;i<m; i++) {
		cin >> cnt;

		int first;
		cin >> first;

		for (int j = 1; j < cnt; j++) {
			int num;
			cin >> num;
			v[first].push_back(num);
			group_size[num]++;
			first = num;
		}

	}
	topologySort();

	if (seq.size() == n) {
		for (int i = 0; i < seq.size(); i++) {
			cout << seq[i] << '\n';
		}
	}
	else cout << 0;

	return 0;
}

//https://bbeomgeun.tistory.com/110 참고