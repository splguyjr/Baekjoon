#include <iostream>
#include <cstring>

using namespace std;

int k;
int arr[14];
int dfs_arr[7];
bool visited[14];

void dfs(int idx, int depth) {
	if (depth == 6) {
		for (int i = 0; i < 6; i++) {
			 cout << dfs_arr[i] << " ";
		}
		cout << '\n';
		return;
	}
	
	for (int i = idx; i <= k; i++) {
		dfs_arr[depth] = arr[i];
		dfs(i + 1, depth +1);
	}

	return;
}

int main() {
	
	cin >> k;
	
	while (k) { 
		for (int i = 1; i <= k; i++) {
			cin >> arr[i];
		}
		dfs(1, 0);

		cout << '\n';
		cin >> k;
	}

	return 0;

}