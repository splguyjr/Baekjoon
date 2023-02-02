#include <iostream>
#include <algorithm>

using namespace std;

pair<int, int> flower[100001];
int n, m, d;
int st, ed;

int main() {
	cin >> n;
	for(int i =0; i<n; i++) {
		cin >> m >> d;
		st = 100 * m + d;
		cin >> m >> d;
		ed = 100 * m + d;
		flower[i] = { st, ed };
	}

	sort(flower, flower + n);

	int temp = 301;

	if (flower[0].first > temp) {
		cout << 0;
		return 0;
	}

	int i = 0;
	int cnt = 0;
	

	while (temp <= 1130) {
	
		int temp1 = temp;
		for (; i < n; i++) {
			if (flower[i].first <= temp1) {
				temp = max(flower[i].second, temp);
			}
			else break;
		}

		if (temp == temp1) {
			break;
		}
		else {
			cnt++;
		}
	}
	
	if (temp >= 1201) cout << cnt;
	else cout << 0;
	
	

	return 0;
}