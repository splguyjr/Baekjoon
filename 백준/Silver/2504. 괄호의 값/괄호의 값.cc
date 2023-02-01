#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack<char> st;
string a;
char temp;
int cnt = 0;
int mlt1 = 1;
int mlt2 = 1;
bool f = false;

int main() {
	cin >> a;
	for (int i = 0; i < a.size(); ++i) {
		temp = a[i];
		if (temp == '(') {
			st.push(temp);
			mlt1 = mlt1 * 2;
		}
		else if (temp == '[') {
			st.push(temp);
			mlt2 = mlt2 * 3;
		}
		else if (temp == ')') {
			if (st.empty() || mlt1 == 1) { cout << 0; return 0; }
			if (a[i - 1] == '(') {
				cnt += mlt1 * mlt2;
				mlt1 /= 2;
				st.pop();
			}
			else {
				mlt1 /= 2;
				st.pop();
			}
		}
		else if (temp == ']') {
			if (st.empty() || mlt2 == 1) { cout << 0; return 0; }
			if (a[i - 1] == '[') {
				cnt += mlt1 * mlt2;
				mlt2 /= 3;
				st.pop();
			}
			else {
				mlt2 /= 3;
				st.pop();
			}
		}

		}

	if (!st.empty()) { cout << 0; return 0; }

	cout << cnt << '\n';

		return 0;
	}