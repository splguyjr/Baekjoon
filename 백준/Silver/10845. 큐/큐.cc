#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
	
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);
	
	queue<int> q;
	int n;
	cin>>n;
	
	while(n--) {
		string a;
		cin >> a;
		
		if(a =="push") {
			int temp;
			cin >> temp;
			q.push(temp);
		}
		
		else if (a=="pop") {
			if(!q.empty()) {
				cout <<q.front() << '\n';
				q.pop();
			}
			else cout <<"-1" <<'\n';
		}
		
		else if (a=="size") {
			cout << q.size()<<'\n';
		}
		
		else if (a=="empty") {
			if(q.empty()) {
				cout << "1" <<'\n';
			}
			
			else {cout << "0"<<'\n';}
		}
		
		else if (a=="front") {
			if(!q.empty()) {
				cout <<q.front() << '\n';
			}
			else cout <<"-1" <<'\n';
		}
		
		else if (a=="back") {
			if(!q.empty()) {
				cout <<q.back() << '\n';
			}
			else cout <<"-1" <<'\n';
		}
		
	}
	return 0;
}