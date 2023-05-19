#include <iostream>
#include <string>

using namespace std;

string s;

int main() {
	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 65 && s[i] <= 90) s[i] += 32;
		else s[i] -= 32;
	}

	cout << s;

	return 0;
}