#include <iostream>
#include <deque>
using namespace std;

int main() {
	int N, M;
	
	cin >> N >> M;
	
	deque<int> dq;
	
	int temp;
	int count=0;
	
	for(int i =1; i<=N; i++) {
		dq.push_back(i);
	}

	for(int i = 0 ; i <M ;i++) {
		cin >> temp;
		
		int num_index;
		for(int i = 0; i< dq.size(); i++) {
			if(temp == dq[i])
				num_index = i;
		}
		
	
		
		if(num_index <= dq.size()/2) {
			for(int i = 0; i<num_index; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
				count++;
			}
			dq.pop_front();
		}	
		else {
			for(int i =0; i<dq.size()-num_index; i++) {
				dq.push_front(dq.back());
				dq.pop_back();
				count++;
			}
			dq.pop_front();
		}
		
	
		
		
	}
	
	cout << count << endl;
	return 0;
}