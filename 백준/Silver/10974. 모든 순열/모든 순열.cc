#include <iostream>
using namespace std;

int N;
int list[8];
bool visited[8];
	
void solve(int cnt) {
	for(int i =0; i< N; i++) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) 
				cout << list[i]+1 <<' ';
			cout << '\n';
			
			return;	
		}
		
	
	}
	
	for(int i =0; i< N; i++) {
		if(!visited[i]) {
			list[cnt] = i;
			visited[i] = true;
			solve(cnt+1);
			visited[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin >> N;
	
	solve(0);
	return 0;
}