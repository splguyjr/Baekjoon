#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

//-97 -6 -2 6 98

int n;
vector<long long> liq;


int main() {
	cin >> n;
	int x;

	for (int i = 0; i < n; i++) {
		cin >> x;
		liq.push_back(x);
	}

	sort(liq.begin(), liq.end());


	long long first, second, third;
	
	long long total_min_sum = 3000000001;

	for (int i = 0; i < n-2; i++) {
		int l = i + 1, r = n - 1;
		while (l < r) {
			long long min_sum = liq[i] + liq[l] + liq[r];
			if (abs(min_sum) < total_min_sum) {
				total_min_sum = abs(min_sum);
				first = liq[i];
				second = liq[l];
				third = liq[r];
			}

			if (min_sum< 0) l++;
			else r--;
		}

	}
	
	cout << first << " " << second << " " << third;

	return 0;
}