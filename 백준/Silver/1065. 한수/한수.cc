#include <iostream>
#include <string>

using namespace std;

int n;
string s;
int cnt = 0;

//0 1 2
bool check(string s) {
	int temp = s[1] - s[0];
	
	for (int i = 0; i < s.size() - 1; i++) {
		int j = i + 1;
		
		if ((s[j] - s[i]) != temp) {
			return false;
		}

	}

	return true;
}

int main() {
	cin >> n;

	if (n <= 9) {
		cout << n << '\n';
		return 0;
	}

	for (int i = 10; i <= n; i++) {
		s = to_string(i);
		if (check(s)) cnt++;
	}

	cnt += 9;
	cout << cnt << endl;
	return 0;
}