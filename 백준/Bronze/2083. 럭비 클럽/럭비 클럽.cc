#include <iostream>
#include <string>

using namespace std;

string s;
int age, weight;

int main() {


	while (true) {
		cin >> s >> age >> weight;
		if (s == "#" && age == 0 && weight == 0) return 0;

		if (age > 17 || weight >= 80) {
			cout << s << ' ' << "Senior" << '\n';
		}

		else { cout << s << ' ' << "Junior" << '\n'; }
	}


	return 0;
}