#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	string S;
	getline(cin, S);
	stack<char> st;
	bool check = false;
	
	for(char ch: S) {
		
		if(ch == '<') {
			while(!st.empty()) {
				cout << st.top();
				st.pop();
			}
			
			cout << "<";
			check = true;
			
	
		}
		
		else if (ch == '>') {
			cout << '>';
			check = false;
			
		}
		
		else if (check) {
			cout << ch;
		}
		
			else if (!check && ch == ' ') {
			while(!st.empty()) {
				cout << st.top();
				st.pop();
			}
			cout << " ";
		}
		
		else if (!check) {
			st.push(ch);
		}
		
	
		

	
	}
	
	
		while(!st.empty()) {
				cout << st.top();
				st.pop();
			}
	return 0;
}