#include <iostream>

using namespace std;

long long a, b, c;
int ans;

long long pow(long long b) {
	if (b == 0) return 1;

	if (b == 1) return a % c;

	long long x = pow(b / 2) % c;

	if (b % 2 == 0) return x * x % c;

	return  x % c * x % c * a % c;
}

int main() {
	cin >> a >> b >> c;
	cout << pow(b);

	return 0;
}