#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string a, b;
int x, y;

int main() {
	cin >> a >> b;
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());

	x = stoi(a);
	y = stoi(b);

	int sum = x + y;
	string ans = to_string(sum);
	reverse(ans.begin(), ans.end());

	cout << stoi(ans);


	return 0;
}
