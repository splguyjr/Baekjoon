#include <iostream>
#include <algorithm>

using namespace std;

int a, b, c;

int main() {

	do { cin >> a >> b >> c;
	if (a + b + c) {
		if (max({a, b, c}) == a) {
			if (c * c + b * b == a * a) {
				cout << "right" << '\n';
			}
			else cout << "wrong" << '\n';
		}
		else if (max({ a, b, c }) == b) {
			if (a * a + c * c == b * b) {
				cout << "right" << '\n';
			}
			else cout << "wrong" << '\n';
		}
		else if (max({ a, b, c }) == c) {
			if (a * a + b * b == c * c) {
				cout << "right" << '\n';
			}
			else cout << "wrong" << '\n';
		}
	}
		
	} while (a+b+c);


	return 0;
}