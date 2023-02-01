#include <iostream>

using namespace std;

int nu[100001];
int nu_sum[100001];


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n, m;
	int a, b;

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		cin >> nu[i];
		nu_sum[i] = nu_sum[i - 1] + nu[i];
	}

	while (m--) {
		cin >> a >> b;
		cout << nu_sum[b] - nu_sum[a - 1] << '\n';
		
	}

	return 0;
}