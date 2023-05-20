#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<pair<int, int>> v;
int arr[1001];

//2 3 1
//a[0] = 2, a[1] = 3, a[2] = 1
//b[p[0]] = 2, b[p[1]] = 3, b[p[2]] = 1
//b[p[2]] = 1, b[p[0]] = 2, b[p[1]] = 3
// 2 0 1 - 0 1 2
// 답은 1,2,0



int main() {
	cin >> n;

	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back({ temp, i });
	}

	sort(v.begin(), v.end());


	for (int i = 0; i < n; i++) {
		arr[v[i].second] = i;
	}

	for (int i = 0; i < n; i++) {
		cout << arr[i] << " ";
	}



	return 0;
}