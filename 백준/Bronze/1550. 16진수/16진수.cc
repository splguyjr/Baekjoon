#include <iostream>
#include <string>

using namespace std;

int main() {

	string n;
	cin >> n;
	cout << stoi(n, nullptr, 16);

	return 0;
}