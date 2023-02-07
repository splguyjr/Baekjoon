#include <iostream>

using namespace std;

int paper[129][129];

int n, color;
int cnt_w = 0, cnt_b = 0;

void check(int x, int y, int n) {
	bool white = true;
	bool blue = true;

	for (int i = x; i < x+n; i++) {
		for (int j = y; j < y+n; j++) {
			if (paper[i][j] == 0) blue = false;
			if (paper[i][j] == 1) white = false;
		
		}
	}


	if (white) { cnt_w++; return; }

	else if (blue) { cnt_b++; return; }

	check(x, y, n / 2);
	check(x, y + n / 2, n / 2);
	check(x + n / 2, y, n / 2);
	check(x + n / 2, y + n / 2, n / 2);
	

	return;

}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> paper[i][j];
		}
	}

	check(0, 0, n);
	
	cout << cnt_w << '\n';
	cout << cnt_b << '\n';

	
	return 0;
}