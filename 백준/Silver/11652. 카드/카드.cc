#include <iostream>
#include <map>
using namespace std;

map<long long, int> program;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	while (n--) {
		long long temp;
		cin >> temp;
		program[temp]++;
	}
	
	long long max = 0;
	long long ans = 0;

	for (auto iter : program) {
		if (iter.second > max) {
			max = iter.second;
			ans = iter.first;
		}
	}

	cout << ans;

	return 0;
}