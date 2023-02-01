#include <iostream>
#include <algorithm>

using namespace std;

int n;
int color[3][1001];
int cost[3];

int main() {
	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		cin >> cost[0] >> cost[1] >> cost[2];
		color[0][i] = min(color[1][i - 1], color[2][i - 1]) + cost[0];
		color[1][i] = min(color[0][i - 1], color[2][i - 1]) + cost[1];
		color[2][i] = min(color[0][i - 1], color[1][i - 1]) + cost[2];
	}

	cout << min({ color[0][n],color[1][n],color[2][n] });
	


	return 0;
}