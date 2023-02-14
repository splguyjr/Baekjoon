#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n;
int k;
int m;
int v;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;

	vector<pair<int, int>> jewel(n);
	vector<int> bag(k);

	for (int i = 0; i < n; i++) {
		cin >> jewel[i].first >> jewel[i].second;
	}

	for (int j = 0; j < k; j++) {
		cin >> bag[j];
	}

	sort(jewel.begin(), jewel.end());
	sort(bag.begin(), bag.end());

	priority_queue<int> pq;

	int idx = 0;
	long long ans = 0;

	for (int i = 0; i < k; i++) {

		while(idx <n && jewel[idx].first <= bag[i]){
				pq.push(jewel[idx++].second);
			}
	
		if (!pq.empty()) {
		ans += pq.top();
		pq.pop();
		}
	}
		cout << ans;

		return 0;
	}