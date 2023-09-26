#include <iostream>
#include <string>
#include <stack>
#include <algorithm>

using namespace std;

string s;
stack<int> score;

int main() {
	cin >> s;
	
	int a, b;
	for (int i = s.size()-1; i >=0; i--) {

		if (s[i] == 'x') { score.push(0); }

		else if (s[i] == 'g') {

			if (!score.empty()) {
				a = score.top();
				score.pop();
				score.push(a + 1);
			}

			else{ cout << -1; 
			return 0;
			}
			
		}

		else if (s[i] == 'f') {
			if (score.size() >= 2) {
				a = score.top();
				score.pop();
				b = score.top();
				score.pop();
				score.push(min(a, b));
			}
			else {
				cout << -1;
				return 0;
			}
		}
	}

	if (score.size() == 1) {
		cout << score.top();
	}

	else cout << -1;

	return 0;
}