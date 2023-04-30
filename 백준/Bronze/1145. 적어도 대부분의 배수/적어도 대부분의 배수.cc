#include <iostream>

using namespace std;

int arr[5];

int main() {
	
	for (int i = 0; i < 5; i++) {
		cin >> arr[i];
	}

	int i = 1;
	bool check = true;

	while (check) {
		int cnt = 0;
		for (int j = 0; j < 5; j++) {
			if (i % arr[j] == 0) {
				cnt++;
			}
			if (cnt == 3) { check = false; break; }
		}
		if(check) { i++; }
		
	}

	cout << i;
	



	return 0;
}