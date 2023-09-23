#include <iostream>
#include <string>

using namespace std;

int n;
string p, q, r;
char a,b;
bool check = false;


bool check_two(int t, string x, string y) {
	for (int i = t; i < n; i++) {
		if (x[i] == y[i]) {
			continue;
		}

		else {
			if (x[i] != y[i] && y[i] == a && x[i] == b)  {
				return false;
		}
			return true;
		}
		
	}
	return false;
}

int main() {
	cin >> n;
	cin >> p >> q >> r;

	for (int i = 0; i < n; i++) {
		if (p[i] != q[i] && q[i] != r[i] && p[i] != r[i]) {
			check = true;
			break;
		}

		else if (p[i] == q[i] && q[i] != r[i]) {
			a = q[i]; b = r[i];
			if (check_two(i + 1, p, q)) {
				check = true;
			}
			break;
		}

		else if (p[i] != q[i] && q[i] == r[i]) {
			a = p[i]; b = q[i];
			if (check_two(i + 1, q, r)) {
				check = true;
			}
			break;
		}

		else if (p[i] == r[i] && q[i] != r[i]) {
			break;
		}
	}

	if (check) cout << "HJS! HJS! HJS!";

	else cout << "Hmm...";

	return 0;
}