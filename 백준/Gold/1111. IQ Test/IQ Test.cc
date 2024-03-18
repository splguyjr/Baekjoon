#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[51];

int main() {

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	if (n == 1) {
		cout << "A";
		return 0;
	}

	if (n == 2) {
		if (arr[1] == arr[2]) cout << arr[1];
		else cout << "A";
		return 0;
	}

	vector<pair<int, int>> v;

	
	for (int j = -200; j <= 200; j++) {
		int x = j;
		int y = arr[2] - j * arr[1];
		if (arr[3] == x * arr[2] + y) {
			v.push_back({ x, y });
			if (x == 1 && y == 0) {
				break;
			}
		}
	}

	bool check = false;
	int a ,b;

	for (int i = 0; i < v.size(); i++) {
		int x = v[i].first;
		int y = v[i].second;

		for (int i = 2; i <= n-1; i++) {
			if (arr[i + 1] != arr[i] * x + y) {
				break;
			}
			if (i == n - 1) {
				check = true;
				a = x; b = y;
			}
		}
	}
	
	if (!check) {
		cout << "B";
	}

	else {
		cout << arr[n] * a + b;
	}

	return 0;
}