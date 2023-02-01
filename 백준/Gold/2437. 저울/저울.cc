#include <iostream>
#include <algorithm>


using namespace std;

int n, sum;
int d[1001];

int main() {
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> d[i];
	}

	sort(d, d + n);

	for (int i = 0; i < n; ++i) {
		if (sum + 1 >= d[i]) sum += d[i];
	}

	cout << sum+1;
}