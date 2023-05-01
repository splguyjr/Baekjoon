#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
char arr[51][51];
int check_row[51];
int check_col[51];

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++)	{
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'X') {
				check_row[i] = 1;
				check_col[j] = 1;
			}
		}
	}

	int row_cnt = 0;
	int col_cnt = 0;

	for (int i = 0; i < n; i++) {
		if (check_row[i] == 0) {
			row_cnt++;
		}	
	}
	
	for (int j = 0; j < m; j++) {
		if (check_col[j] == 0) {
			col_cnt++;
		}
	}

	cout << max(row_cnt, col_cnt);

	return 0;
}