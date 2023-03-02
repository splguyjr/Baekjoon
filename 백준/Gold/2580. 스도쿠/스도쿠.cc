#include <iostream>

using namespace std;

int sudoku[9][9];
int cnt = 0; // 0의 갯수
int cnt_dfs = 0;
bool found = false;

bool promising(int a, int b) {
	int x = a / 3;
	int y = b / 3;
	
	for (int i = 0; i < 9; i++) {
		if (b != i && sudoku[a][i] == sudoku[a][b]) return false;
		if (a != i && sudoku[i][b] == sudoku[a][b]) return false;
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (a != 3 * x + i || b != 3 * y + j) {
				if (sudoku[a][b] == sudoku[3*x + i][3*y + j])
					return false;
			}
		}
	}

	return true;

}

void dfs(int x, int y, int c) {
	

	if (c == cnt) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << sudoku[i][j] << ' ';
			}
			cout << '\n';
		}

		found = true;
		return;
	}
				
			
	
	


	
	if (sudoku[x][y] == 0) {
		for (int k = 1; k <= 9; k++) {
			sudoku[x][y] = k;
			if (promising(x, y)) { 
				if (y == 8) dfs(x + 1, 0, c+1);
				else dfs(x, y+1, c+1); 
				if (found) return;
				
				
			}
		}
		sudoku[x][y] = 0;
		return;
	}

	if (y == 8) dfs(x + 1, 0, c);
	else dfs(x, y + 1,c);
	
}



int main() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> sudoku[i][j];
			if (sudoku[i][j] == 0) cnt++;
		}
	}

	dfs(0,0,0);




	return 0;
}