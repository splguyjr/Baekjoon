#include <iostream>

using namespace std;

int x, y;

int year[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
string day[7] = { "SUN","MON","TUE","WED","THU","FRI","SAT" };
int sum = 0;

int main() {
	cin >> x >> y;

	for (int i = 0; i < x-1; i++) {
		sum += year[i];
	}

	sum += y;

	cout << day[sum % 7];

	return 0;
}