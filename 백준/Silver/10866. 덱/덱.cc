#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);
	cout.tie(NULL);
	
	deque<int> dq;
	int N;
	
	cin >> N;
	
	string input;
	int temp=0;
	
	while(N--) {
		cin >> input;
		if(input == "push_front") {
			cin >> temp;
			dq.push_front(temp);
		}
		
		else if(input == "push_back") {
			cin >> temp;
			dq.push_back(temp);
		}
		
		else if(input == "pop_front") {
			if(!dq.empty()) {
				cout << dq.front() <<'\n';
				dq.pop_front();
			}
			else cout << "-1"<<'\n';
			
		}
		
		else if(input == "pop_back") {
			if(!dq.empty()) {
				cout << dq.back() <<'\n';
				dq.pop_back();
			}
			else cout << "-1"<<'\n';
			
		}
		
		else if(input == "pop_back") {
			if(!dq.empty()) {
				cout << dq.back() <<'\n';
				dq.pop_back();
			}
			else cout << "-1"<<'\n';
			
		}
		
		else if(input == "size") {
			cout << dq.size()<<'\n';
			
		}
		
		else if(input == "empty") {
			cout <<dq.empty()<<'\n';
			
		}
		
		else if(input == "front") {
			if(!dq.empty()) {
				cout << dq.front() <<'\n';
			}
			else cout << "-1"<<'\n';
			
		}
			
		else if(input == "back") {
			if(!dq.empty()) {
				cout << dq.back() <<'\n';
			}
			else cout << "-1"<<'\n';
			
		}
		
			
	}
	
	
	return 0;
}