#include <iostream>
#include <vector>
#include <string>

using namespace std;

char word[101];
vector<int> Cap;
vector<int> underline;

int main() {
	int type;
	cin >> type;


	string word;

	cin >> word;

	for (int i = 0; i < word.size(); ++i) {
		if (word[i] <= 90) {
			Cap.push_back(i);
		}
	}

	for (int i = 0; i < word.size(); ++i) {
		if (word[i] == '_') underline.push_back(i);
	}

	if (type == 1) {
		cout << word << '\n';

		bool cap = false;

		for (int i = 0; i < word.size(); ++i) {

			for (int j = 0; j < Cap.size(); ++j) {
				if (i == Cap[j]) {
					cout << "_";
					cap = true;
				}
			}
			if (cap) { cout << char(word[i] + 32); cap = false; continue; }
			cout << word[i];
		}
		cout << '\n';

		cout << char(word[0] - 32);
		for (int i = 1; i < word.size(); ++i) {
			cout << word[i];
		}
	}

	else if (type == 2) {
		bool skip = false;
		bool cap = true;
		for (int i = 0; i < word.size(); ++i) {

			for (int j = 0; j < underline.size(); ++j) {
				if (i == underline[j]) {
					j = i;
					skip = true;
				}
			}

			if (skip) { skip = false; cap = false; continue; }
			if (!cap) { cout << char(word[i] - 32); cap = true; continue; }
			cout << word[i];

		}
		cout << '\n';

		cout << word << '\n';

		cout << char(word[0] - 32);

		for (int i = 1; i < word.size(); ++i) {

			for (int j = 0; j < underline.size(); ++j) {
				if (i == underline[j]) {
					j = i;
					skip = true;
				}
			}

			if (skip) { skip = false; cap = false; continue; }
			if (!cap) { cout << char(word[i] - 32); cap = true; continue; }
	
			cout << word[i];
		}
		cout << '\n';

	}

	else if (type == 3) {
		cout << char(word[0] + 32);
		for (int i = 1; i < word.size(); ++i) {
			cout << word[i];
		}
		cout << '\n';

		bool cap = false;

		cout << char(word[0] + 32);
		for (int i = 1; i < word.size(); ++i) {

			for (int j = 0; j < Cap.size(); ++j) {
				
				if (i == Cap[j]) { cout << "_";  cap = true; }
			}
			if (cap) { cout << char(word[i] + 32); cap = false; continue; }
			cout << word[i];
		}
		cout << '\n';
		cout << word;
	}

	return 0;
}