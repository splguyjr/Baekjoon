#include <iostream>
#include <string>
using namespace std;

int main() {
	string a;
	cin >> a;
	int b[26];
	

	
	for (int i =0; i < 26; i++) {
		b[i] = -1;
	}
	
	int num = 0;
		
	for (int i =0; i <a.size(); i++) {
		
		if(b[a[i]-97] != -1){
			num++;
			continue;}
		b[a[i]-97] = num++;
	}

	for (int i =0; i < 26; i++) {
		cout << b[i] << ' ';
	}

	return 0;
}