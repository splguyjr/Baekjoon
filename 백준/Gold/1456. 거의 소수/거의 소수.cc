#include <iostream>
#include <cmath>
using namespace std;

bool prime[10000001];


int main() {
	long int a,b;
	cin >> a>>b;
	
	for(int i =2; i<=sqrt(b); i++) {
		if(prime[i] == true) continue;
		for(int j = i+i; j<=sqrt(b); j+=i) {
			prime[j] = true;
		}
	}
	prime[1] = true;
	

	
	int count = 0;
	
	for(int i = 2; i<=sqrt(b); ++i) {
		if(prime[i] == false) {
		
				for(int j = 2; pow(i,j) <= b; j++) {
					if(pow(i,j)>= a)
					count +=1;
				}
		
			
		}
	}
	
	cout << count;
	
	return 0;
}