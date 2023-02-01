#include <iostream>
#include <string>

using namespace std;

int main() {
	string a;
	cin >> a;

	string b;

	b = a;
	if (a.size() % 3 == 1)
		b = "00" + a;
	if (a.size() % 3 == 2)
		b = "0" + a;

	a = "";

	for (int i = 0; i < b.size(); i = i+3) {
		if (b.substr(i, 3) == "111") {
			a += '7';		}
		else if (b.substr(i, 3) == "110") {
			a += '6';
		}
		else if (b.substr(i, 3) == "101") {
			a += '5';
		}
		else if (b.substr(i, 3) == "100") {
			a += '4';
		}
		else if (b.substr(i, 3) == "011") {
			a += '3';
		}
		else if (b.substr(i, 3) == "010") {
			a += '2';
		}
		else if (b.substr(i, 3) == "001") {
			a += '1';
		}
		else if (b.substr(i, 3) == "000") {
			a += '0';
		}


	}

	cout << a;

	return 0;
	
}