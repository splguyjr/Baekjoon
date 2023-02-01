#include <iostream>
#include <cmath>
using namespace std;

bool prime(int input) {
	for(int i =2; i<=sqrt(input); i++) {
		if(input %i==0) return false;
	}
	return true;
}

int main() {
	
	cin.tie(NULL);
    cout.tie(NULL);
	ios_base :: sync_with_stdio(false);
	int n =1;
	int a,b;
	
	while(n) {
		cin >> n;
		for(int i=1; i<n/2; i++) {
			
			a = 2 * i + 1;
			b = n-a;
			
			if(prime(a) && prime(b)) {
				cout << n << " = " << a << " + " << b << '\n';
				
				break;
			}
		
		}
		
		
	
}

}
