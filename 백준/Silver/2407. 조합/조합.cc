#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
string dp[102][102];

string add(string a, string b) {
	string ans = "";
	int sum = 0;
	int length = max(a.size(), b.size());

	for (int i = 0; (i < length) || sum; i++) {
		if (a.size() > i) sum += (a[i] - '0');
		if (b.size() > i) sum += (b[i] - '0');
		ans += ((sum % 10) + '0');
		sum /= 10;
	}

	return ans;
}

string combination(int a, int b) {
	if (a == b || b == 0) return "1";

	string &result = dp[a][b];
	
	if (result != "") return result;
	

	result = add(combination(a - 1, b - 1), combination(a - 1, b));
	return result;
}


int main() {
	cin >> n >> m;

	string ans = combination(n, m);
	reverse(ans.begin(), ans.end());
	cout << ans;

	return 0;
}