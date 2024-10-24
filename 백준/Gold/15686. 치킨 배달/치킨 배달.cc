#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

#define INF 1e9;

using namespace std;

int n, m, cnt;
vector<pair<int, int>> house;
vector<pair<int, int>> chicken;
vector<int> visited;//방문한 치킨집 인덱스를 저장
int ans = INF;

void input() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int temp;
			cin >> temp;
			if (temp == 1) {
				house.push_back({ i,j });
			}
			else if (temp == 2) {
				chicken.push_back({ i,j });
			}
		}
	}


}

int dis(int x1, int x2, int y1, int y2) {
	return abs(x1 - x2) + abs(y1 - y2);
}

void cal() {
	int distance = INF;
	int sum = 0;
	int x1, y1, x2, y2;
	for (int i = 0; i < house.size(); i++) {
		x1 = house[i].first;
		y1 = house[i].second;
		for (int j = 0; j < visited.size(); j++) {	
			x2 = chicken[visited[j]].first;
			y2 = chicken[visited[j]].second;
			distance = min(distance, dis(x1, x2, y1, y2));//한 집에 대하여 모든 치킨집과의 거리중 최소
		}
		sum += distance;
		distance = INF;
	}
	ans = min(ans, sum);
}

void dfs(int idx, int cnt) {
	if (cnt == m)
		return cal();

	else {
		for(int i = idx; i < chicken.size();i++) {
			visited.push_back(i);
			dfs(i + 1, cnt + 1);
			visited.pop_back();
		}
	}

}

int main() {

	input();
	dfs(0, 0);
	cout << ans;

	return 0;
}