#include <iostream>

using namespace std;

int a, b, c, d;
string s = "DCBAE";
//배0 등1 
int main() {
	for (int i = 0; i < 3; i++) {
		cin >> a >> b >> c >> d;
		int temp = a + b + c + d;

		cout << s[temp] << endl;
	}


	return 0;
}