#include <iostream>
#include <cmath>

using namespace std;

int n;
double total_space = 0;
pair<double, double> shape[10002];

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> shape[i].first >> shape[i].second;
	}

	shape[n + 1] = shape[1];

	for (int i = 1; i <= n; i++) {
		total_space += shape[i].first * shape[i + 1].second;
		total_space -= shape[i + 1].first * shape[i].second;

	}

	total_space = abs(total_space) / 2;

	cout << fixed;
	cout.precision(1);
	cout << total_space;

	return 0;
}