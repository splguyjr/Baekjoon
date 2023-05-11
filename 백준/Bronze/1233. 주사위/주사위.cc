#include <iostream>
#include <algorithm>

using namespace std;

int s1, s2, s3;
int arr[81];

int main() {
	cin >> s1 >> s2 >> s3;

	for (int i = 1; i <= s1; i++) {
		for (int j = 1; j <= s2; j++) {
			for (int k = 1; k <= s3; k++) {
				arr[i + j + k]++;
			}
		}
	}

	int temp;
	int mx = 0;
	for (int i = 3; i <= s1 + s2 + s3; i++) {
		if (mx < arr[i]) {
			temp = i;
			mx = arr[i];
		}
	}

	cout << temp;


	return 0;
}