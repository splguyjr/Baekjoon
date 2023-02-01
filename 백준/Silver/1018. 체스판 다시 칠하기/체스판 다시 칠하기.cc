#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
string line;
char map[51][51];
int minimum = 64;

int main() {

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < n-7; i++) {
		for (int j = 0; j < m - 7; j++) {
			int count_wb = 0;
			int count_bw = 0;

			for (int x = i; x < i + 8; x++) {
				for (int y = j; y < j + 8; y++) {
					if (x % 2 == 0) {
						if (y % 2 == 0) {
							if (map[x][y] == 'W') count_bw++;
							else count_wb++;
						}
						else if (y % 2 == 1) {
							if (map[x][y] == 'W') count_wb++;
							else count_bw++;
						}
					}

					else if (x % 2 == 1) {
						if (y % 2 == 0) {
							if (map[x][y] == 'W') count_wb++;
							else count_bw++;
						}
						else if (y % 2 == 1) {
							if (map[x][y] == 'W') count_bw++;
							else count_wb++;
						}
					}

					

				}
			}
			minimum = min({ minimum, count_wb, count_bw });

			count_wb = 0, count_bw = 0;

		}
	}

	cout << minimum;

	return 0;
}