#include <iostream>
#include <cmath>

using namespace std;



int main() {
	int x1, y1, x2, y2;
	int a, b, r;
	int t, n;
	int cnt = 0;

	cin >> t;
	
	while (t--) {
		cin >> x1 >> y1 >> x2 >> y2;
		cin >> n;
		while (n--) {
			cin >> a >> b >> r;
			if (pow(x1 - a, 2) + pow(y1 - b, 2) < pow(r, 2)) {
				if (pow(x2 - a, 2) + pow(y2 - b, 2) > pow(r, 2)) {
					cnt++;
				}
			}

			else if (pow(x1 - a, 2) + pow(y1 - b, 2) > pow(r, 2)) {
				if (pow(x2 - a, 2) + pow(y2 - b, 2) < pow(r, 2)) {
					cnt++;
				}
			}

			
		}
		cout << cnt << endl;
		cnt = 0;
	}


	return 0;
}