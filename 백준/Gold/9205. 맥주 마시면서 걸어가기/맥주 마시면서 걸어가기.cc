#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
#include <cstring>


using namespace std;

pair<int, int> store[100];
int visited[100];
int n;//편의점 개수
int t;
pair<int, int> home;
pair<int, int> festival;



bool check(pair<int, int> a, pair<int, int> b) {
	if (abs(a.first - b.first) + abs(a.second - b.second) <= 1000)
		return true;
	
	return false;
}

bool bfs() {
	queue<pair<int, int>> q;
	q.push(home);

	while(!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (check(festival, { x,y })) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			if (check(store[i], {x,y})) { 
				q.push(store[i]);
				visited[i] = 1;
			}			
		}
	}

	return false;
}

int main() {
	cin >> t;

	while (t--) {
		cin >> n;
		cin >> home.first >> home.second;

		for (int i = 0; i < n; i++) {
			cin >> store[i].first >> store[i].second;
		}

		cin >> festival.first >> festival.second;

		bool temp = bfs();
		if (temp) cout << "happy" << '\n';
		else cout << "sad" << '\n';

		memset(visited, 0, sizeof(visited));
	}


	return 0;
}