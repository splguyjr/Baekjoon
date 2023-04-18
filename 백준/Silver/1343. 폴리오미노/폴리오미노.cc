#include <iostream>

using namespace std;

string x;
string ans = "";

int main() {

	cin >> x;
	
	int cnt = 0;
	for (int i = 0; i < x.size(); i++) {
		if (x[i] == 'X') {
			cnt++;
		}

		if (x[i] == '.') {
			if (cnt % 2 != 0) {
				cout << -1;
				return 0;
			}
			
			else {
				ans += ".";
				cnt = 0;
			}
		}

		if (cnt == 2) {
			if (x[i + 1] != 'X') {
				ans += "BB";
				cnt = 0;
			}
		}
		else if (cnt == 4) {
			ans += "AAAA";
			cnt = 0;
		}


	}

	if (cnt % 2 == 1) cout << -1;
	else cout << ans;

	return 0;
}