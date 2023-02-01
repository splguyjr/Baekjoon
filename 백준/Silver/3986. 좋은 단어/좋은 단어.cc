#include <iostream>
#include <stack>
#include <string>

using namespace std;



int main() {
	string word;
	bool check = true;
	int c = 0;
	int n;
	cin >> n;

	while (n--) {
		stack<char> good;
		cin >> word;
		char temp;
		for (int i = 0; i < word.length(); ++i) {
			temp = word[i];
			if (temp == 'A') {
				if (good.size() >= 2) {
					if (good.top() == 'B') { good.push(temp); check = false; }

					else { good.pop(); }
				}

				else {
					if (!good.empty() && good.top() == 'B') { good.push(temp); }
					else if (!good.empty()) good.pop();
					else good.push(temp);
		
				}

			}

			else if (temp == 'B') {
				if (good.size() >= 2) {
					if (good.top() == 'A') { good.push(temp); check = false; }
					else { good.pop();  }
				}
				else {
					if(!good.empty() && good.top()=='A') good.push(temp);
					else if (!good.empty()) good.pop();
					else good.push(temp);
				}
			}

		}
		
		if (good.empty()) c++;
		check = true;
	}

	cout << c;


	return 0;

}