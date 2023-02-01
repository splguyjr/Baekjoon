#include <iostream>
#include <unordered_set>
#include <string>

using namespace std;

unordered_set<string> count;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n, m;
	cin >> n >> m;

	while (n--) {
		string temp;
		cin >> temp;
		count.insert(temp);
	}

	while (m--) {
		string temp;
		cin >> temp;

		int index = 0;
		int nindex = 0;
		while ((nindex = temp.find(',', index)) != string::npos) {
			count.erase(temp.substr(index, nindex - index));
			index = nindex + 1;
		}
		count.erase(temp.substr(index));
		cout << count.size()<<'\n';
	}
	return 0;
}