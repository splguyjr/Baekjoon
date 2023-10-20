#include <iostream>
#include <algorithm>

using namespace std;

int n, money, mx;
int arr[100001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> money >> mx;

	//선물 반값 미리 처리
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		arr[i] /= 2;
	}

	sort(arr, arr + n);

	int temp = 0;//현재까지 구매한 물건들의 총 가격
	int ans = 0;
	for (int i = 0; i < n; i++) {
		temp += arr[i];

		if (i >= mx) {
			temp += arr[i - mx];
		}

		if (temp > money) {
			ans = i;
			break;
		}

		ans = i+1;

	}

	cout << ans;

	return 0;
}