#include <iostream>

using namespace std;

int a, b, c, d;


int main() {
	cin >> a >> b >> c >> d;

	c += d;
	b += c / 60;
	a += b / 60;
	c %= 60;
	b %= 60;
	a %= 24;
	
	cout << a << ' ' << b << ' ' << c;

	return 0;
}