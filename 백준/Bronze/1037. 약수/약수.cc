#include <iostream>
using namespace std;

int main() {
	int n;
	
	cin >> n;
	
	int min=1000000;
	int max=0;
	int check;
	while(n--) {
		cin >> check;
		if(min> check) min = check;
		if(max< check) max = check;
		
	}
	
	cout << min*max;
	return 0;
}