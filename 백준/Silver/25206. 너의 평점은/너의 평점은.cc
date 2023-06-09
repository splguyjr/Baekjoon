#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> v;
double grade[10] = { 0.0,1.0,1.5,2.0,2.5,3.0,3.5,4.0,4.5 };
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
		if (g == "A+") {
			t1 = t1 * 4.5;
		}
		else if(g == "A0") {
			t1 = t1 * 4.0;
		}
		else if (g == "B+") {
			t1 = t1 * 3.5;
		}
		else if (g == "B0") {
			t1 = t1 * 3.0;
		}
		else if (g == "C+") {
			t1 = t1 * 2.5;
		}
		else if (g == "C0") {
			t1 = t1 * 2.0;
		}
		else if (g == "D+") {
			t1 = t1 * 1.5;
		}
		else if (g == "D0") {
			t1 = t1 * 1.0;
		}
		else if (g == "F") {
			t1 = t1 * 0;
		}
		sum += t1;
		
	}

	cout << sum / cnt;

	return 0;
}