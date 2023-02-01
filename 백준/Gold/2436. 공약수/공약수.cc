#include <iostream>
using namespace std;

int GCD(int a, int b) {
	int c =a%b;
	while(c !=0) {
		a = b;
		b = c;
		c= a%b;
	}
	
	return b;
}

int main() {
	int gcd, lcm;
	cin>> gcd>>lcm;
	int temp = lcm/gcd;
	int num;
	
	for(int i=1; i*i<=temp; i++) {
		
		if(temp%i ==0) {
			
			if(GCD(i, temp/i)==1) {
			num = i;
			}
		
		}
		
	}
	cout << gcd*num << ' '<<gcd*temp/num;
 	
	return 0;
}