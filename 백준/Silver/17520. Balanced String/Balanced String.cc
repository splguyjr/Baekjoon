#include <iostream>
#include <cmath>
using namespace std;

int main() {

	long long n;
	cin >> n;

	int answer = 1;
	int num = (n - 1) / 2 + 1;
	while (num) {
		answer *= 2;
		answer %= 16769023;
		num--;
	}

	cout << answer;

	
	return 0;

}