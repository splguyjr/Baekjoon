#include <iostream>

using namespace std;

char tree[3072][6144];

void star(int x, int y, int n) {
	tree[x][y] = '*';
	tree[x+1][y-1] = '*';
	tree[x+1][y+1] = '*';
	tree[x+2][y-2] = '*';
	tree[x+2][y-1] = '*';
	tree[x+2][y] = '*';
	tree[x+2][y+1] = '*';
	tree[x+2][y+2] = '*';

	if (n > 3) {
		star(x + n / 2, y - n / 2, n / 2);
		star(x + n / 2, y + n / 2, n / 2);
		star(x, y, n / 2);
	}

}

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n - 1; j++) {
			tree[i][j] = ' ';
		}
	}

	star(0, n-1, n);


	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n - 1; j++) {
			cout << tree[i][j];
		}
		cout << '\n';
	}


	return 0;
}