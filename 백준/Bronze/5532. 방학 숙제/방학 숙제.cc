#include <iostream>
#include <algorithm>

using namespace std;

int day;
int a, b, c, d;

int main() {
	cin >> day >> a >> b >> c >> d;
	
	int t1, t2;

	if (a % c == 0) t1 = a / c;
	else t1 = a / c + 1;

	if (b % d == 0) t2 = b / d;
	else t2 = b / d + 1;

	cout << day - max(t1,t2);

	return 0;
}