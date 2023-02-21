#include <iostream>

using namespace std;

int n, m;
int sum;
int arr[101];

bool closer(int s) {
	if (m - sum > m-s) return true;
	return false;
}

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				int temp = arr[i] + arr[j] + arr[k];
				if(temp <= m) {
					if (temp == m) { cout << m; return 0; }
					if (closer(temp)) sum = temp;
				}
				
			}
		}
	}

	cout << sum;

	return 0;
}