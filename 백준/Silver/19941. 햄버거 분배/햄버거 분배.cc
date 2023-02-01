#include <iostream>
#include <string>

using namespace std;

int main() {
	int n, k;
	int cnt =0;
	cin >> n >> k;

	string ph;
	cin >> ph;

	for (int i = 0; i < n; ++i) {
		if (ph[i] == 'P') {
				for(int j= i-k; j<=i+k; ++j) {
					if (j >= 0 && j <= n) {
						if (ph[j] == 'H') { ph[j] = 'A'; 
						cnt++;
						break;
						}
					}
			}
		}
	}
	
	cout << cnt;
}