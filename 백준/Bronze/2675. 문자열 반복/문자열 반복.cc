#include <iostream>
#include <string>
using namespace std;

int main() {
	int t;
	cin >> t;
	while(t--) {
		int n;
		string b;
		cin >> n >> b;
		for(int i = 0; i< b.length(); i++) {
			for(int j = 0; j<n; j++) {
				cout << b[i];
			}
		}
		cout << endl;
	}
	
	return 0;
}