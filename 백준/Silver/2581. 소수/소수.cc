#include <iostream>
using namespace std;

bool prime[10001];

int main() {
	int a,b;
	
	cin>>a>>b;
	
	
	for(int i =2; i<=b; i++) {
		if(prime[i] == true) continue;
		for(int j = i+i; j<=b; j+=i){
			prime[j] = true;
		}
	}
    prime[0] = true;
	prime[1] = true;
	int sum=0;
	int min=0;
	bool done = false;
	for(int i=a; i<=b; i++) {
		if(prime[i] == false) {
			sum += i;
			
			if(done == false) {min = i;
			
			done = true;}
		}
	}
	
	if(done == false) cout << "-1";
	
	else{cout << sum << '\n' << min;}
	
	return 0;
}