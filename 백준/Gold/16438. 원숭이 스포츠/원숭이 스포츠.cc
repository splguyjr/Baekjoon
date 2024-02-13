#include <iostream>
#include <algorithm>

using namespace std;

int n;
int print_cnt = 0;
char arr[8][100];


void dq(int st, int ed, int depth) {
	print_cnt = max(print_cnt, depth);

	if (st >= ed || depth == 7) return;
	
	int mid = (st + ed) / 2;
	
	for (int i = st; i <= ed; i++) {
		if (i <= mid) arr[depth][i] = 'A';
		else arr[depth][i] = 'B';
	}

	dq(st, mid, depth+1);
	dq(mid+1, ed, depth+1);
}





int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	dq(0, n - 1, 0);

	for (int i = 0; i < print_cnt; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == '\0') {
				arr[i][j] = 'A';
			}
		cout << arr[i][j];
		}
		cout << '\n';
	}

	while (print_cnt < 7) {
		cout << 'A';

		for (int i = 1; i < n; i++) {
			cout << 'B';
		}

		cout << '\n';

		print_cnt++;
	}
	return 0;
}