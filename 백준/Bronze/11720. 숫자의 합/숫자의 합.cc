#include <iostream>
#include <string>

using namespace std;

int main() {

	int num;
	cin >> num;

	char b;

	int sum =0;

	getchar();

	
	for (int i = 0; i < num; i++) {
	b = getchar();
			sum += b - 48;
			
		}

	
	
	cout << sum;
} 