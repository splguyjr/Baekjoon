#include <iostream>

using namespace std;

int n;
long long b;
int mat[6][6];
int ans[6][6];
int temp[6][6];

void pow(int x[6][6], int y[6][6]) {
	
	
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			temp[i][j] = 0;
			for (int k = 0; k < n; k++) {
				temp[i][j] += x[i][k] * y[k][j];
			}
			temp[i][j] %= 1000;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			x[i][j] = temp[i][j];
		}
	}
		

}


int main() {
	cin >> n >> b;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> mat[i][j];
		}
		ans[i][i] = 1;
	}


	while (b) {
		if (b % 2 == 1) {
			pow(ans, mat);
		}
		pow(mat, mat);
		b /= 2;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << ans[i][j] << ' ';
		}
		cout << '\n';
	}



	return 0;
}