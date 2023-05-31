#include <iostream>
#include <vector>

using namespace std;

int n, k;
string s;
vector<char> v;

int main() {

	cin >> n >> k >> s;
	int i = 0;

	while (i != s.size()) {
		while (k != 0 && !v.empty() && v.back() < s[i]) {
			v.pop_back();
			k--;
		}
		v.push_back(s[i]);
		i++;
	}

	while (k--) {
		v.pop_back();
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i];
	}




	return 0;
}

//https://dbstndi6316.tistory.com/98 참고