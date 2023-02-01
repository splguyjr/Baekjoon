#include <iostream>
#include <queue>

using namespace std;

priority_queue<int> pq;

int main() {
	int n;
	cin >> n;

	while (n--) {
		int temp;
		cin >> temp;
		if (temp) {
			while (temp--) {
				int price;
				cin >> price;
				pq.push(price);
			}
		}

		else {
			if (pq.empty()) cout << "-1" << '\n';

			else {
				cout << pq.top() << '\n';
				pq.pop();
			}

		}
	}

	return 0;
}