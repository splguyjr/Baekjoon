#include <iostream>
#include <string>

using namespace std;

int main() {
	int n;
	int lst[8];
	string check = "";
	
	for (int i = 0; i < 8; i++) {
		cin >> lst[i];
		check += to_string(lst[i]);
	}
	
	if (check == "12345678")
		cout << "ascending";

	else if (check == "87654321")
		cout << "descending";
	else cout << "mixed";

	return 0;
}