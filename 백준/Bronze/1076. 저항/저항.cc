#include <iostream>
#include <cmath>

using namespace std;

int arr[3];

int main() {
	string color[10] = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
	string a;
	
	
	
	for (int i = 0; i < 3; i++) {
		cin >> a;
		for (int j = 0; j < 10; j++) {
			if (color[j] == a) {
				arr[i] = j;
			}
		}
	}

	long long ans = 0;
	ans = arr[0] * 10 + arr[1];
	ans *= pow(10, arr[2]);

	cout << ans;


	return 0;
}