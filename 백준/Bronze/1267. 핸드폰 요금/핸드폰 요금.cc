#include <iostream>

using namespace std;

int main() {
	int num;
	int time;

	int M=0;//60초 15원
	int Y=0;//30초 10원
	cin >> num;

	for (int i = 0; i < num; i++) {

		cin >> time;
		Y += (time / 30 + 1) * 10;
		M += (time / 60 + 1) * 15;


	}
	
	if (Y > M) {
		cout << "M ";
		cout << M;
	}
	else if (Y == M) {
		cout << "Y M ";
		cout << Y;
	}
	else {
		cout << "Y ";
		cout << Y;
	}
}