#include <iostream>

using namespace std;

int n;
int arr[101];

void flip(int& x) {
	if (x == 1) x = 0;
	else x = 1;
}

void swch(int a, int b) {
	if (a == 1) {//남학생
		int temp = b;
		while (b <= n) {
			flip(arr[b]);
			b += temp;
		}
	}

	else if (a == 2) {//여학생
		flip(arr[b]);

		int i = 1;
		while (b - i >= 1 && b + i <= n) {
			if (arr[b - i] == arr[b + i]) {
				flip(arr[b - i]);
				flip(arr[b + i]);
				i++;
			}
			else break;
		}		
	}

	return;
}

void print() {
	int cnt = 0;

	for (int i = 1; i <= n; i++) {
		cnt++;
		cout << arr[i] << " ";
		if (cnt == 20) {
			cout << '\n';
			cnt = 0;
		}
	}
}
int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	int t, a, b;

	cin >> t;

	while (t--) {
		cin >> a >> b;

		swch(a, b);
	}

	print();

	return 0;
}	
