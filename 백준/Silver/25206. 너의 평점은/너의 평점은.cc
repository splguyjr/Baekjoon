#include <iostream>
#include <string>

using namespace std;

string grade[9] = { "F","D0","D+","C0","C+","B0","B+","A0","A+" };
double grade_num[9] = { 0.0,1.0,1.5,2.0,2.5,3.0,3.5,4.0,4.5 };
double sum = 0;
int cnt = 0;

int main() {

	string s;
	double t1 = 0;
	string g;

	for (int i = 0; i < 20; i++) {
		cin >> s;
		cin >> t1 >> g;

		if (g == "P") {
			continue;
		}
		cnt += t1;
		for (int j = 0; j < 9; j++) {
			if (grade[j] == g) {
				t1 = t1 * grade_num[j];
			}
		}
		sum += t1;
		
	}

	cout << sum / cnt;

	return 0;
}