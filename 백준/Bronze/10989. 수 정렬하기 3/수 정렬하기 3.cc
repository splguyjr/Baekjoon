#include <iostream>

using namespace std;

int arr[10001];
int n;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	int x;

	while (n--) {
		cin >> x;
		arr[x]++;
	}

	for (int i = 1; i <= 10000; i++)
	{
		while (arr[i]) {
			cout << i << '\n';
			arr[i]--;
		}
	}
	return 0;
}