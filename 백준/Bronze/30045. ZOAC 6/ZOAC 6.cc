#include <iostream>
#include <string>

using namespace std;

int n;
string s;
int cnt = 0;

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			if (s[j] == '0') {
				if (j < s.size() - 1) {
					if (s[j+1] == '1') {
						cnt++;
						break;
					}
				}
			}

			else if (s[j] == 'O') {
				if (j < s.size() - 1) {
					if (s[j+1] == 'I') {
						cnt++;
						break;
					}
				}
			}
		}
	}

	cout << cnt;

	return 0;
}