#include <iostream>

using namespace std;

int p, n, m;
int period=0;

int main() {
	
	cin >> p;
	while (p--) {
		int m1 = 1, m2 = 1;
		cin >> n >> m;
		
		do{
		int temp = m1;
		m1 = m2;
		m2 = (temp + m2) % m;
		period++;
		} while (m1 != 1 || m2 != 1);

		cout << n << ' ' << period << '\n';
		period = 0;
		
	}


	return 0;
}