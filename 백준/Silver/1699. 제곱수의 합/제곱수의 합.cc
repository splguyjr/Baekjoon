#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int n;
	cin >> n;
	
	int a[n+1] = {0};
	int min = 100000;
	for(int i = 1; i<=n; ++i) {
		for(int j = 1;  pow(j,2)<=i; j++) {
			int temp =pow(j,2);
			a[i] = a[i-temp] + 1;
			
			if(min > a[i])
				min = a[i];
			a[i] = min;
		}
	
		min = 100000;
	}
	cout <<a[n];
	return 0;
}