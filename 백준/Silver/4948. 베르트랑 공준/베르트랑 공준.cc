#include <iostream>
using namespace std;


bool prime[250000]={true,true};

int main() {

	while(true) {
		int a;
		cin >> a;
		if(a == 0) break;
		
		for(int i = 2; i<=2*a; i++) {
			if(prime[i] == true) continue;
			for(int j = i+i; j<=2*a; j+=i) {
				prime[j] = true;
			}
		}
		
		int count = 0;
		for(int i = a+1; i<=2*a; i++) {
			if(prime[i] == false) count++;
		}
		
		cout << count << '\n';
	}

	return 0;
}