#include <iostream>
#include <string>
#include <vector>

using namespace std;

int arr[9][9];
bool visited[81];
vector<pair<int,int>> v;
bool check = false;

bool check_row(int x, int y,int num) {
	for (int i = 0; i < 9; i++) {
		if (arr[x][i] == num)
			return false;
	}
	return true;
}

bool check_col(int x, int y, int num) {
	for (int i = 0; i < 9; i++) {
		if (arr[i][y] == num)
			return false;
	}
	return true;
}

bool check_sq(int x, int y, int num) {
	int a = x / 3;
	int b = y / 3;

	for (int i = 3* a; i < 3*a + 3; i++) {
		for (int j = 3 * b; j < 3 * b + 3; j++) {
			if (arr[i][j] == num)
				return false;
		}
	}

	return true;
}

bool promising(int x, int y, int num) {
	if (check_row(x, y,num) && check_col(x, y,num) && check_sq(x, y,num)) return true;
	return false;
}

void dfs(int cnt) {
	if (cnt == v.size()) {
		check = true;
		return;
	}

	visited[cnt] = true;
	
	int x = v[cnt].first;
	int y = v[cnt].second;
	
	for (int k = 1; k <= 9; k++) {

		if (promising(x,y, k)) {
			arr[x][y] = k;
			dfs(cnt+1);
			if (check) return;
			arr[x][y] = 0;
			}
	}

	if (check) return;
	visited[cnt] = false;


}

int main() {
	string line;

	for (int i = 0; i < 9; i++) {
		cin >> line;
		for (int j = 0; j < 9; j++) {
			arr[i][j] = line[j] - '0';
			if (arr[i][j] == 0) {
				v.push_back({ i,j });
			}
		}
	}

	dfs(0);

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cout << arr[i][j];
		}
		cout << '\n';
	}
	



	return 0;
}