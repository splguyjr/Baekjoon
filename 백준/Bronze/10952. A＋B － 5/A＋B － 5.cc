#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int a = 1,b =1;
	
	while (a + b >0) {
		cin>>a>>b;
		if ( a+b == 0) {
			break;
		}
		cout << a+b<<endl;
	}
	
	return 0;
}
