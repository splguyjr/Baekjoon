#include <iostream>

using namespace std;

int x;
int start = 64;
int sum = 0;
int ans = 0;
//x보다 크면, 가장 짧은 걸 반토막, 반은 버리고 
//안버리면 더하기
int main() {
	cin >> x;
	if (x == 64) {
		cout << 1;
		return 0;
	}
	while (sum != x) {
		start /= 2;
		if (sum + start <= x) {
			sum += start;
			ans++;
		}

	}

	cout << ans;


	return 0;
}