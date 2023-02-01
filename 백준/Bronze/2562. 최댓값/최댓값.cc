#include <iostream>

using namespace std;

int main() {
	int n[9];
	int mx = 0;
	int mx_index = 0;
	for (int i = 0; i < 9; i++) {
		cin >> n[i];
		if (mx < n[i]) {
			mx = n[i];
			mx_index = i + 1;
		}
		
	}

	
	cout << mx << '\n' << mx_index;
		

	return 0;
}