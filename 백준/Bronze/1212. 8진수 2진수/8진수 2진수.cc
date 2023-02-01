#include <iostream>
#include <string>

using namespace std;

int main() {

	string a;
	cin >> a;

	string b = "";
	for (int i = 0; i < a.size(); i++) {
		if (a.substr(i, 1) == "0") {
			b += "000";
		}
		else  if (a.substr(i, 1) == "1") {
			b += "001";
		}
		else  if (a.substr(i, 1) == "2") {
			b += "010";
		}
		else  if (a.substr(i, 1) == "3") {
			b += "011";
		}

		else  if (a.substr(i, 1) == "4") {
			b += "100";
		}
		else  if (a.substr(i, 1) == "5") {
			b += "101";
		}
		else  if (a.substr(i, 1) == "6") {
			b += "110";
		}
		else  if (a.substr(i, 1) == "7") {
			b += "111";
		}


	}

	a = b;

	

	if (a.substr(0, 2) == "00") {
		a = a.substr(2);
		cout << a;
	}
	else if (a.substr(0, 1) == "0") {
		a = a.substr(1);
	cout << a;
}
	else { cout << a; }
}