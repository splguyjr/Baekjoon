#include <iostream>

using namespace std;

int a, b, c, d, ans;

int main() {

	cin >> a >> b >> c >> d;
	ans = a + b + c + d;

	cin >> a >> b >> c >> d;
	if (ans < a + b + c + d) ans = a + b + c + d;
	cout << ans;


	return 0;
}