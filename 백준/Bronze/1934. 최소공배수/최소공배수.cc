#include <iostream>

using namespace std;

int main() {
	int num;
	cin >> num;
	while(num > 0) {

	int a, b, max, temp;

	cin >> a >> b;
	max = a * b;
	while (a % b != 0) {
		temp = a % b;
		a = b;
		b = temp;
	}
	
	cout << max / b<<'\n';

	num = num - 1;
	}
}