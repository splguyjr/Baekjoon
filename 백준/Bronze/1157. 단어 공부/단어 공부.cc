#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

bool comp(pair<char, int> a, pair<char, int> b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second;
}

int main() {
	string word;
	cin >> word;
	unordered_map<char, int> um;

	int word_size = word.size();
	for (int i = 0; i < word_size; i++) {
		if (97 <= word[i] && word[i] <= 122) {
			word[i] -= 32;
		}
		um[word[i]]++;

	}

	vector<pair<char,int >> v(um.begin(), um.end());

	sort(v.begin(), v.end(), comp);

	int check = 0;
	
	if (v.size() != 1 && v[0].second == v[1].second) {
		cout << '?';
		return 0;
	}

	cout << v[0].first;



	return 0;
}