#include <iostream>
#include <deque>

using namespace std;

deque<int> dq;
int n,k,m;
int del_per=0;

int main() {
	cin >> n >> k >> m;
	for(int i =1; i<=n; ++i) {
		dq.push_back(i);
	}
	
	for(int i =1; i<= n*k; ++i) {
		
	if((del_per/m)%2 ==0) {
		if(i%k) {int temp = dq.front();
				dq.pop_front();
				dq.push_back(temp);
			
		}
		else{
		cout<< dq.front() <<endl; 
	
			dq.pop_front();
			del_per++;
		}
	}
	
	else {
		if(i%k) {int temp = dq.back();
				dq.pop_back();
				dq.push_front(temp);
			
		}
		else{
			int temp = dq.back();
				dq.pop_back();
				dq.push_front(temp);
		cout<< dq.front() <<endl; 
			dq.pop_front();
			del_per++;
		}
	}
	
	}
	return 0;
}