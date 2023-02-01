#include <iostream>
#include <string>

using namespace std;


int main() {
	string a;
	cin >> a;
	int n = 0;
	
	while (n < a.size())
	{
		cout << a[n];
		if (n % 10 == 9) {
			cout << endl;
		}
		n++;
	}

}