#include <iostream>
using namespace std;

int max(int a, int b) {
	return (a>b) ? a : b;
}

int n;
int t[15];
int p[15];
int x = 0;


void dp(int day, int sum) {
	if(day > n) return;
	
	x = max(x, sum);
	
	for(int i=day; i<n; i++) {
		dp(i+t[i], sum+p[i]);
	}
}

int main() {
	
	cin >> n;
	
	for(int i=0; i<n; i++) {
		cin >> t[i]>> p[i];
	}
	
	dp(0,0);
	cout <<x;
	
	return 0;
}