#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	bool b;
	
	int a;

	int num=0;

	while (n > 0) {
		b = true;
		cin >> a;
		if (a == 1) {
			b = false;
		}

		if (a > 2 && a % 2 == 0) {
			b = false;
		}
		else if (a > 3 && a % 3 == 0) {
			b = false;
		}
		else if (a > 5 && a % 5 == 0) {
			b = false;
		}
		else if (a > 7 && a % 7 == 0) {
			b = false;
		}
		else if (a > 11 && a % 11 == 0) {
			b = false;
		}
		else if (a > 13 && a % 13 == 0) {
			b = false;
		}
		else if (a > 17 && a % 17 == 0) {
			b = false;
		}
		else if (a > 19 && a % 19 == 0) {
			b = false;
		}
		else if (a > 23 && a % 23 == 0) {
			b = false;
		}
		else if (a > 29 && a % 29 == 0) {
			b = false;
		}
		else if (a > 31 && a % 31 == 0) {
			b = false;
		}
		
		if (b) {
			num++;
		}
		n = n - 1;
	}
	

	cout << num;
}