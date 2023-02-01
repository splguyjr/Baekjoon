#include <iostream>
#include <string>
using namespace std;

int main() {
	string n;
	
	cin >> n;
	
	int count = 0;
	
	while(n.size() > 1) {
		int x=0;

	for(int i=0; i<n.size(); i++) {
		x += int(n[i]) -48; //아스키코드상 "1"은 49
		
	}
	n = to_string(x);
	
	
	count++;
	

	
	}
	
	

	cout << count <<endl;
	if(stoi(n)%3 ==0) cout << "YES";
	else cout <<"NO";


	
	return 0;
}