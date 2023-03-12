#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n;
priority_queue<int> pq;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	int x;
	while (n--) {
		cin >> x;
		if (x > 0) { pq.push(x); }
		else {
			if (pq.empty()) {
				cout << 0 << '\n';
				continue;
			}
			cout << pq.top() << '\n';
			pq.pop();
		}
		
	}


	return 0;

}