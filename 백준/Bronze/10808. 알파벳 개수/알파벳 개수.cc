#include <iostream>
#include <string>
using namespace std;
int A[26];

int main() {
	string str;
	cin >> str;
	
	for (int i =0; i<str.length(); i++) {
		A[str[i]-97]++;
	}
	
	for (int i = 0; i < 26; i++) {
		cout << A[i]<< ' ';
	}
	return 0;
}