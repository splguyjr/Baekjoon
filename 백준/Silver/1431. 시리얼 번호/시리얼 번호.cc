#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<string,int>> v;
string serial_number;
int n;

bool compare(pair<string, int> p1, pair<string, int>p2) {
	if (p1.first.size() == p2.first.size() && p1.second == p2.second)
		return p1.first < p2.first;
	else if (p1.first.size() == p2.first.size())
		return p1.second < p2.second;
	return p1.first.size() < p2.first.size();
}

void result(string a) {
	int sum = 0;
	for (int i = 0; i < a.size(); ++i) {
		
		if (a[i] - '0' < 10) { sum += int(a[i] - '0');}
		
	}
	v.push_back({ a,sum });
}

int main() {
	cin >> n;
	while (n--) {
		cin >> serial_number;
		result(serial_number);
	}

	sort(v.begin(), v.end(),compare);

	for (auto elem : v)
		cout << elem.first << '\n';



	return 0;
	
}