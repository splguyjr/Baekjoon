#include <iostream>
#include <stack>
using namespace std;

int main() {
	string a;
	cin >> a;
	
	stack<char> left, right;
	for(int i =0; i<a.size(); i++) {
		left.push(a[i]);
	}
	
	int n;
	cin >> n;
	while(n--) {
		char command;
		
		
		cin >> command;
		if(command == 'L') {
			if(left.empty()) continue;
			right.push(left.top());
			left.pop();
		
		}
		
		else if(command == 'D') {
			if(right.empty()) continue;
			left.push(right.top());
			right.pop();
			
		}
		
		else if(command == 'B') {
			if(left.empty()) continue;
			left.pop();
		}
		
		
		else if(command == 'P') {
			char temp;
			cin >> temp;
			left.push(temp);
		}
	}
	
	while(!left.empty()) {
		right.push(left.top());
		left.pop();
	}
	
	while(!right.empty()) {
		cout << right.top();
		right.pop();
	}
	
	return 0;
}