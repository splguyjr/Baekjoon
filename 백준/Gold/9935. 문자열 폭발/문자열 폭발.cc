#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack<char> s;
string str;
string ex;
string temp;

int main() {
	
	cin >> str;
	cin >> ex;

	for (int i = 0; i < str.size(); i++) {
		temp += str[i];

		if (temp.size() >= ex.size()) {
			bool check = true;
			for (int j = 0; j < ex.size(); j++) {
				if (temp[temp.size() - ex.size() + j] != ex[j]) {
					check = false;
					break;
				}
			}
			if (check) {
				temp.erase(temp.end() - ex.size(), temp.end());
			}
		}
	}
	if (temp.size() == 0) {
		cout << "FRULA";
		return 0;
	}
	cout << temp;



	return 0;
}