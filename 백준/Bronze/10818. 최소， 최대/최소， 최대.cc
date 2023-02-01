#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;
	cin >> n;
	int x;
	int	mi = 1000000,mx= -1000000;
	while (n--) {
		cin >> x;
		if (mi > x) mi = x;
		if (mx < x) mx = x;

	}

	cout << mi << ' ' << mx;
	return 0;
}