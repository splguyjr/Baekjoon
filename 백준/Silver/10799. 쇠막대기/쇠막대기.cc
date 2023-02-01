#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	stack<char> st;
	string input;
	int lazer = 0;
	
	
	cin >> input;
	for(int i = 0; i<input.size(); i++) {
		if(input.at(i) == '(') {
			st.push('(');
		}
		else if(input[i] == ')')
		{
			if(input[i-1] == '(') {
				st.pop();
				lazer += st.size();
			}
			else {st.pop();
				lazer++;
				
			}
		}
}
	
	cout << lazer;
	
	return 0;
}