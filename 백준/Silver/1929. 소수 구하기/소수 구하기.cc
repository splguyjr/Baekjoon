#include <iostream>

using namespace std;

int arr[1000000];

int main() {
	int a, b;
	cin >> a >> b;

	for (int i = 2; i <= b; i++) {
		arr[i] = i;
	}

	for (int i = 2; i <= b; i++) {
		if (arr[i] == 0) {
			continue;
		}
		for (int j = i + i; j <= b; j += i) {
			arr[j] = 0;
		}
	}

	for (int i = a; i <= b; i++) {
		if (arr[i] != 0) {
			cout << arr[i]<<'\n';
		}

	}
}