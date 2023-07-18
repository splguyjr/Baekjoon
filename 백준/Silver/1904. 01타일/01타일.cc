#include <iostream>

using namespace std;

int n;
int arr[1000001] = { 1,1 };

int main() {
	cin >> n;
	for (int i = 0; i <= n-2; i++) {
		arr[i + 2] = (arr[i + 1] + arr[i]) %15746;
	}
	cout << arr[n];

	return 0;

}