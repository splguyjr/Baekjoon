#include <iostream>
#include <queue>

using namespace std;

int n;
int ans = 0;
priority_queue<int, vector<int>, greater<int>> pq;

void combine_card() {
	int a, b;

	while (pq.size() != 1) {
		a = pq.top();
		pq.pop();
		b = pq.top();
		pq.pop();

		ans += a + b;
		pq.push(a + b);
	}
}

int main() {
	cin >> n;

	int temp;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		pq.push(temp);
	}

	combine_card();

	cout << ans;

	return 0;
}