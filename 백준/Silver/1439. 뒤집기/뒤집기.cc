#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string s;
int count0 = 0;
int count1 = 0;

int main() {

	cin >> s;
	bool check0 = false;
	bool check1 = false;

	for (int i = 0; i < s.size(); i++) {
		if (check0 && s[i] == '0') {
			continue;
		}
		
		else if (check1 && s[i] == '1') {
			continue;
		}

		else if (s[i] == '0') {
			check0 = true;
			check1 = false;
			count0++;
		}

		else if (s[i] == '1') {
			check1 = true;
			check0 = false;
			count1++;
		}
	}

	cout << min(count0, count1);






	return 0;
}