#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

string s;
int ans = 0;
bool isMinus = false;

int stt(string s) {
	int x = stoi(s);
	return x;
}

int main() {

	cin >> s;

	char c;
	string temp;

	for (int i = 0; i < s.size(); i++) {
		c = s[i];

		if (isMinus == false) {
			if (c == '-') {
				isMinus = true;
				ans += stt(temp);
				temp = "";
			}

			else if (c == '+') {
				ans += stt(temp);
				temp = "";
			}

			else {
				temp += s[i];
			}
		}

		else {
			if (c == '-' || c == '+') {
				ans -= stt(temp);
				temp = "";
			}

			else {
				temp += s[i];
			}
		}
	
	}

	if (isMinus) {
		ans -= stt(temp);
	}
	else {
		ans += stt(temp);
	}

	cout << ans;

	return 0;
}