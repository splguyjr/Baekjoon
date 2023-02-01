#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int m, n;
	cin >> m >> n;

	int sum = 0;
	int first = 0;
	bool a = false;
	int num = 0;
	for (int i = 1; i <= sqrt(n); i++) {
		if (pow(i, 2) >= m && pow(i, 2) <= n) {
			sum += pow(i, 2);
			if (first == 0) {
				num = pow(i, 2);
				a = true;
			}
			first += 1;
		}
		
		

	}
	if (a == true) {
		cout << sum << endl;
		cout << num;
	}

	else if (a == false) {
		cout << -1;
	}
}