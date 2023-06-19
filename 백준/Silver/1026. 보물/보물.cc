#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[101];
int arr1[101];
int sum = 0;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++) {
		cin >> arr1[i];
	}

	sort(arr, arr + n);
	sort(arr1, arr1+n,greater<int>());

	for (int i = 0; i < n; i++) {
		sum += arr[i] * arr1[i];
	}

	cout << sum;

	return 0;
}