#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
string word;
unordered_map<string, int> um;
vector<string> v;

bool compare(string a, string b) {
	if (um[a] == um[b] && a.size() == b.size()) return a < b;
	else if (um[a] == um[b]) return a.size() > b.size();
	return um[a] > um[b];
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;
	while (n--) {
		cin >> word;
		if (word.size() >= m) {
			if (um.find(word) == um.end()) {
				um[word] = 0;
				v.push_back(word);
			}
			else {
				um[word]++;
			}

		}
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
}