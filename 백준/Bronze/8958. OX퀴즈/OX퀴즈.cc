#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;
	cin >> n;
	string x;
	while (n--) {
		cin >> x;
		int score = 0;
		int num_O = 0;
		for (auto elem : x) {
			if (elem == 'O') num_O++;
			else {
				score += num_O * (num_O + 1) / 2;
				num_O = 0;
			}
		}
		if(num_O != 0) score += num_O * (num_O + 1) / 2; num_O = 0;

		cout << score << '\n';
	}

	return 0;
}