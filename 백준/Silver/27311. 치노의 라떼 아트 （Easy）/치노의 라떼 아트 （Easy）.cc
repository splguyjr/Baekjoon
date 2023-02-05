#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int t, n, m;
char heart[101][101];


int main() {
	cin >> t;
	
	


	while(t--) {
		int x_max = 0, x_min = 100;
		int y_max = 0, y_min = 100; //x가 행 y가 열
		cin >> n >> m;

		char temp;

		bool check = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> temp;
			heart[i][j] = temp;
			if (heart[i][j] == '#') {
			x_max = max(x_max, i);
			y_max = max(y_max, j);
			x_min = min(x_min, i);
			y_min = min(y_min, j);
			check = true;
			}
		}
	}

	if (!check) {
		cout << 0 << '\n';
		continue;
	}
	int dif_x = x_max - x_min;
	int dif_y = y_max - y_min;

	
	//각 꼭짓점의 차이를 통해 정사각형형태인지 확인
	if (!(dif_x == dif_y)) {
		cout << 0 << '\n';
		continue;
	}
	

	int cnt = 0;
	for (int i = x_min; i <= x_max; i++) {
		for (int j = y_min; j <= y_max; j++) {
			if (heart[i][j] == '.') cnt++;
		}
	}

	//#정사각형 안의 '.'의 개수가 제곱수인지 확인
	if (sqrt(cnt) != int(sqrt(cnt))) {
		cout << 0 << '\n';
		continue;
	}

	//
	
	int len = sqrt(cnt);
	
	int cas;

	if (heart[x_min][y_min] == '.') {
		cas = 1;
	}
	else if (heart[x_min][y_max] == '.') {
		cas = 2;
	}
	else if (heart[x_max][y_min] == '.') {
		cas = 3;
	}
	else if (heart[x_max][y_max] == '.') {
		cas = 4;
	}
	else { cout << 0 << '\n'; continue; }


	bool skip = false;

	if(cas == 1) {
	for (int i = x_min; i < x_min +len; i++) {
		for (int j = y_min; j < y_min +len; j++) {
			if (heart[i][j] == '#') {
				skip = true;
				break;
			}
		}
		if (skip) break;
	}
	}

	else if (cas == 2) {
		for (int i = x_min; i < x_min + len; i++) {
			for (int j = y_max; j > y_max - len; j--) {
				if (heart[i][j] == '#') {
					skip = true;
					break;
				}
			}
			if (skip) break;
		}
	}

	else if (cas == 3) {
		for (int i = x_max; i > x_max - len; i--) {
			for (int j = y_min; j < y_min + len; j++) {
				if (heart[i][j] == '#') {
					skip = true;
					break;
				}
			}
			if (skip) break;
		}
	}

	else if (cas == 4) {
		for (int i = x_max; i > x_max - len; i--) {
			for (int j = y_max; j > y_max - len; j--) {
				if (heart[i][j] == '#') {
					skip = true;
					break;
				}
			}
			if (skip) break;
		}
	}
	
	if (!skip) cout << 1 << '\n';
	else { cout << 0 << '\n'; }


	}
	return 0;
}