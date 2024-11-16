#include <iostream>
#include <map>
#include <string>

using namespace std;

map<string, int> m;
string str;
double cnt = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout << fixed;
	cout.precision(4);

	while (getline(cin, str)) {
		cnt++;
		m[str]++;
	}

	for (map<string, int>::iterator it = m.begin(); it != m.end(); it++) {
		cout << it->first << ' ' << it->second * 100 / cnt << '\n';
	}

	return 0;
}