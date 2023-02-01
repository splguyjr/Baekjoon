#include <iostream>
#include <queue>

using namespace std;

int main() {
	int N;
	int num,loc,imp;
	
	cin >> N;
	while(N--) {
		queue<pair<int, int>> q;
		priority_queue<int> pq;
		
		cin >> num >> loc;
		for(int i=0; i<num; i++) {
			cin >> imp;
			q.push({i,imp});
			pq.push(imp);
		}
		
		int count = 0;
		
		while(!q.empty()) {
			int currentloc = q.front().first;
			int currentimp = q.front().second;
			q.pop();
			
			if(pq.top() == currentimp) {
				pq.pop();
				count++;
				
				if(currentloc == loc) {
					cout << count << endl;
					break;
				}
				
			}
			
			else q.push({currentloc,currentimp});
			
		}
		}
	return 0;
}