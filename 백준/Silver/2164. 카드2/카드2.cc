#include <iostream>
#include <queue>

using namespace std;

int main() {
	queue<int> q;
	int N;
	cin >> N;
	for(int i=1; i <=N; i++) {
		q.push(i);
	}
	
	int temp;
	while(!(q.size()==1)) {
		q.pop();
		temp = q.front();
		q.pop();
		q.push(temp);
	}
	
	cout <<q.back();
	return 0;
}