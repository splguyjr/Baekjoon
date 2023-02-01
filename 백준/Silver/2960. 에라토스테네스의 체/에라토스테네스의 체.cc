#include <iostream>
using namespace std;

bool a[1001];
	
int main() {
	int n,k;
	cin >> n>>k;
	for(int i =2; i <=n; i++) {
		a[i] = true;
	}
	
	int count = 0;
	for(int i = 2; i <=n; i++) {
		for(int j = i; j<=n; j+=i) {
			if(a[j] == false) continue;
		
			
			a[j] = false;
			count++;
		
			if(count == k) {
				cout << j;
				return 0;
			}
		}
	}
	return 0;
}