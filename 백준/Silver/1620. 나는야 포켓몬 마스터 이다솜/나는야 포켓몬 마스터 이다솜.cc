#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

unordered_map<string, int> pokemon;
string name[100001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; ++i) {
		string temp;
		cin >> temp;
		name[i] = temp;
		pokemon.insert({ temp,i });
	}


	for (int i = 1; i <= m; ++i) {
		string temp;
		cin >> temp;
		if (!isdigit(temp[0])) {
			auto iter = pokemon.find(temp);
			cout << iter->second << '\n';
		}
		else {
			int x = stoi(temp);
			cout << name[x] << '\n';
		}
	}
	return 0;
}