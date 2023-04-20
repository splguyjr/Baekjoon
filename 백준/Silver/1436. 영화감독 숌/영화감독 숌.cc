#include <iostream>

using namespace std;

int n;

int main() {
	cin >> n;
	

	int start = 666;
	int seq = 0;
	int temp;

	while (1) {
		temp = start;

		
		do {
			if (temp % 1000 == 666) {
				seq++;
				break;
			}
			temp /= 10;
		} while (temp >= 666);

		if (seq == n) {
			cout << start;
			break;
		}

		start++;
	}



	return 0;
}