#include <iostream>
#include <cmath>
using namespace std;

bool prime[100000001];

int main() {
	int n;
	cin >> n;
	for(int i =2; i*i <=n; i++) {
		if(prime[i] == true) continue;
		for(int j = i+i; j<=n; j+=i) {
			prime[j] = true;
		}
	}
	
	long long num=1;
	int max=0;
	for(int i =2; i <=n; i++) {
		if(prime[i] == false) {
			for(int j = 1; pow(i,j)<=n; j++) {
				max = j;
			}
			long long temp =pow(i,max);
			num = (num *temp )%4294967296;
		}
	}
	cout << num;
	return 0;
}