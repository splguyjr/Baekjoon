#include <iostream>

using namespace std;

const int MAX = 100;
int gcd[MAX];

int gc(int a, int b)

{

 if (a%b == 0)
    return b;

 

 return gc(b, a%b);

}


int main() {
	int T;
	cin >> T;
	while(T--) {
		int num;
		cin >> num;
		
		for(int i = 0; i< num; i++) {
			cin >> gcd[i];
		}
		long long int sum = 0;
		for(int i = 0; i <num; i++) {
			for(int j = i+1; j<num; j++) {
				sum += gc(gcd[i], gcd[j]);
			}
			
		}
		cout << sum << '\n';
	}
	return 0;
}