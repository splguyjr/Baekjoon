#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<pair<int, int>> class_time;
priority_queue<int, vector<int>, greater<int>> pq;
int cnt = 0;

int greedy(vector<pair<int, int>> v) {
	pq.push(v[0].second);
	cnt++;
	for (int i = 1; i < v.size(); ++i) {
		if (v[i].first < pq.top()) {
			pq.push(v[i].second);
		//	cout << v[i].first << ' ' << v[i].second << '\n';
		//	cout << pq.top() << ' ' << i  << endl;
			cnt++;
		}
		else {
			pq.pop();
			pq.push(v[i].second);
		}

	}

	return cnt;
}

int main() {
	cin >> n;

	int s;
	int t;
	for (int i = 0; i < n; ++i) {
		cin >> s >> t;
		class_time.push_back({ s,t });
	}
	sort(class_time.begin(), class_time.end());

	cout << greedy(class_time);
}