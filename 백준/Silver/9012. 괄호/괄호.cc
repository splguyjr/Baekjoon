#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool check(string str) {
	int length = str.length();
	stack<char> st;
	
	for (int i=0; i<length; i++) {
		char ch = str[i];
		
		if(ch == '(') {
			st.push(ch);
		}
		else {
			if(!st.empty()) {
				st.pop();
			}
			else {
				return false;
			}
		}
	}
	
	return st.empty();
}

int main() {
	
	int n;
	cin >> n;
	
	for(int i =0; i < n; i++) {
		string str;
		cin >> str;
		
		if(check(str)) {
			cout << "YES" << '\n';
		}
		else {
			cout << "NO" << '\n';
		}
	}
	
	return 0;
}
