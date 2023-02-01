#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int T;
	cin >> T;
	int a,b;
	
	int sav;
	sav = T;
	
	while(T--) {
		cin >> a >> b;
		cout <<"Case #"<< sav-T<<": "<< a<<" + "<<b<<" = "<< a+b << '\n';
	
	}
	
	return 0;
}

