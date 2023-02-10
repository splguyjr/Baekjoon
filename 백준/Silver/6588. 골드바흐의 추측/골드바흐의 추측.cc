#include <iostream>
#include <cmath>

using namespace std;

int memo[1000001]; // 1이면 합성수

void prime() {
	for (int i = 2; i * i <= 1000000; i++) {
		if (memo[i] == 1) continue;
			
		for (int j = i * i; j <= 1000000; j += i) {
			memo[j] = 1;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n = 1;
	int a, b;

	prime();

	while (n) {
		cin >> n;

		for (int i = 1; i < n / 2; i++) {

			a = 2 * i + 1;
			b = n - a;

			if (!memo[a]) {
				{
					if (!memo[b]) {
						cout << n << " = " << a << " + " << b << '\n';

						break;

					}
				}
				
			}

		}

	}

}