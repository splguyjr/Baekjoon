#include <iostream>

using namespace std;

int main() {

	string a;
	bool check = true;
	cin >> a;

	while (a != "0") {

		for (int i = 0; i <= a.size()/2; i++) {
			if (a[i] != a[a.size() - i - 1]) {
				cout << "no" << '\n';
				check = false;
				break;
				
			}
		}

		if (check) {
		cout << "yes" << '\n';
		}
		
		check = true;
		cin >> a;

	}

	return 0;
}