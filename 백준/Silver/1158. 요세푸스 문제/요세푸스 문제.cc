#include <iostream>
#include <queue>
using namespace std;

int main() {
	queue<int> que;
	int n,k;
	cin >> n >> k;
	
	cout <<"<";
	for(int i =1; i <= n; i++) {
		que.push(i);//1234567 
		}
		
	for(int i =1; i < n; i++) {	
		for(int j =1; j< k; j++) {//front를 back으로 옮기고 지우기(k-1번)
			que.push(que.front());
			que.pop();
		}
		cout << que.front()<<", ";
		que.pop();
	}
	
	cout << que.front() << ">";
	
	return 0;
}
