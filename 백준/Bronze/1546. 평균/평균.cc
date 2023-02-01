#include <iostream>

using namespace std;

int score_list[1001];

int main() {
	int n;
	cin >> n;

	double mx = 0;
	for (int i = 0; i < n; i++) {
		cin >> score_list[i];
		if (mx < score_list[i]) mx = score_list[i];
	}
	double ans = 0;
	for (int i = 0; i < n; i++) {
		ans += score_list[i] / mx * 100;
	}

	cout << ans / n;
	

	

	
	return 0;
}