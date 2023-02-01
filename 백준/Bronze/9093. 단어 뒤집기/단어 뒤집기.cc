#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	int n;
	cin >> n;
	cin.ignore();

	while (n--) {
		string arr;
		getline(cin, arr);
		arr += ' ';
		stack<char> st;

		for (char ch : arr) 
		{
		    if (ch == ' ' ) {
			while(!st.empty())
				{
					cout << st.top();
					st.pop();
					
				}
				cout << ch;
			}
		    else
		        st.push(ch);
		}
		}
	return 0;
	}