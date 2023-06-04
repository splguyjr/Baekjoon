#include <iostream>

using namespace std;

char grade;
char a[5] = { 'A','B' ,'C' ,'D' ,'F' };
int b[5] = { 4,3,2,1,0 };
double ans = 0;

int main() {

	cin >> grade;
	for (int i = 0; i < 5; i++) {
		if (a[i] == grade) {
			ans += b[i];
			break;
		}
	}

	if (ans == 0) {
		cout << "0.0";
		return 0;
	}

	cin >> grade;
	if (grade == '0') {
		cout << ans << ".0";
		return 0;
	}
	if (grade == '+') {
		ans += 0.3;
	}

	if (grade == '-') {
		ans -= 0.3;
	}
	cout << ans;

	return 0;
}