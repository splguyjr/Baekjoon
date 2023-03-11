#include <iostream>
#include <vector>
#include <queue>
using namespace std;

priority_queue<int,vector<int>,greater<int>> pq;
int n;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	int x;
	while (n--) {
		cin >> x;
		if (x == 0) {
			if (pq.empty()) {
				cout << 0 << '\n'; continue;
			}
			cout << pq.top() << '\n';
			pq.pop();
		}
		else {
			pq.push(x);
		}
	}

	return 0;
}