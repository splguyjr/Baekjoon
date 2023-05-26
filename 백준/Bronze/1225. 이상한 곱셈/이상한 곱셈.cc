#include <iostream>
#include <string>

using namespace std;

string a, b;
long long ans = 0;

int main() {
	cin >> a;

	if (a == "0") {
		cout << 0;
		return 0;
	}
	cin >> b;

	for (int i = 0; i < a.size(); i++) {
		for (int j = 0; j < b.size(); j++) {
			ans += (a[i] - '0') * (b[j] - '0');
		}
	}

	cout << ans;

	return 0;
}