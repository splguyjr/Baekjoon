#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string n;
int arr[10];
int ans = 0;

int main() {
	cin >> n;

	for (int i = 0; i < n.size(); i++) {
		if (n[i] == '6' || n[i] == '9') {
			if (arr[6] == arr[9]) {
				arr[n[i]-'0']++;
			}
			else {
				if (arr[6] > arr[9]) arr[9] = arr[6];
				else arr[6] = arr[9];
			}
		}
		else arr[n[i]-'0']++;

	}

	for (int i = 0; i < 10; i++) {
		ans = max(ans, arr[i]);
	}

	cout << ans;

	return 0;
}