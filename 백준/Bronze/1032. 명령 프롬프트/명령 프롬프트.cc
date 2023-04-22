#include <iostream>
#include <string>

using namespace std;

int n;
string a;

int main() {
	cin >> n;
	cin >> a;

	string temp;

	for (int i = 0; i < n - 1; i++) {
		cin >> temp;
		for (int j = 0; j < a.size(); j++) {
			if (a[j] != temp[j]) {
				a[j] = '?';
			}
		}
	}
	cout << a;





	return 0;
}