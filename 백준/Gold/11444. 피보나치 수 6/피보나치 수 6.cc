#include <iostream>
#include <vector>

using namespace std;

typedef vector<vector<long long>> matrix;

const int mod = 1000000007;
unsigned long long n;

matrix operator * (matrix& a, matrix& b) {
	matrix c(2, vector<long long>(2));

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 2; k++) {
				c[i][j] += a[i][k] * b[k][j];
			}
			c[i][j] %= mod;
		}
	}

	return c;
}



int main() {
	matrix a = { {1,1},{1,0} };
	matrix ans = { {1,0},{0,1} };
	
	cin >> n;

	while (n > 0) {
		
		if (n % 2 == 1) {
			ans = ans * a;
		}
		a = a * a;
		n /= 2;

	}

	cout << ans[1][0];

	return 0;

}