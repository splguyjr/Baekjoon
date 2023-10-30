#include <iostream>
#include <cmath>
#include <string>

using namespace std;

long long n;
int ans = 0;
int arr[10] = { 9,9,90,90,900,900,9000,9000,90000,90000 };

string reverse(string s) {
	string rev = s;

	for (int i = 0; i < s.size(); i++) {
		rev[s.size() - 1 - i] = s[i];
	}

	return rev;
}

int len(long long n) {
	int cnt = 0;
	while (n) {
		n /= 10;
		cnt++;
	}
	return cnt;
}

int main() {
	cin >> n;
	
	if (n <= 9) {
		cout << n;
		return 0;
	}

	for (int i = 0; i < len(n) - 1; i++) {
		ans += arr[i];
	}

	

	long long temp;
	string s;

	int x = len(n) / 2;

	if(len(n) % 2 == 1) {
		for (int i = pow(10, x - 1); i < pow(10, x); i++) {
			s = reverse(to_string(i));
			for (int j = 0; j <= 9; j++) {
				temp = i * pow(10, x + 1) +j * pow(10, x) + stoi(s);
				if (temp <= n) {
					ans++;
				}
			}
		}
	}

	else {
		for (int i = pow(10, x - 1); i < pow(10, x); i++) {
			s = reverse(to_string(i));
			temp = i * pow(10, x)+ stoi(s);
				if (temp <= n)
					ans++;
		}
	}

	cout << ans;

	return 0;
}