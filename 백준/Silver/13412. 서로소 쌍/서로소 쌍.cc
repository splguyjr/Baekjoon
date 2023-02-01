#include <iostream>
#include <cmath>
using namespace std;

int gcd(int a, int b) {
	if(a%b==0) return b;
	
	else return gcd(b, a%b);


	
}

int main() {
	int T;
	cin >> T;
	while(T--) {
		int a;
		cin >> a;
		int count = 0;
		for(int i=1; i<=sqrt(a); i++) {
			if(a%i == 0) {
			
				if(gcd(a/i,i)==1) count++;
			}
		}
		cout<< count <<'\n';
	}
	return 0;
}