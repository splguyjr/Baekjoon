#include <iostream>
using namespace std;

int main() {

	int a,b;
	cin >> a>>b;
	
	int num[b+1];
	
	int temp = 1;
	int index = 1;
	
	for(int i =1; i<=b; i++) {
		for(int j =1; j <=temp && index <=b; j++) {
			num[index++] = temp;
		}
		temp++;
	}
	
	int sum=0;
	for(int i =a; i<=b; i++) {
		sum += num[i];
	}
	
	cout << sum;
	return 0;
}