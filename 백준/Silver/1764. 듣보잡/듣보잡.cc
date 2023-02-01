#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<string> a;//듣
vector<string> c;//듣보
int n, m;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;

	string temp;

	while (n--) {
		cin >> temp;
		a.push_back(temp);
	}
	sort(a.begin(), a.end());

	while (m--) {
		cin >> temp;
		if(binary_search(a.begin(), a.end(), temp)) c.push_back(temp);
	}


	sort(c.begin(), c.end());

	cout << c.size() << '\n';
	for (int i = 0; i < c.size(); ++i) {
		cout << c[i] << '\n';
	}
	

}