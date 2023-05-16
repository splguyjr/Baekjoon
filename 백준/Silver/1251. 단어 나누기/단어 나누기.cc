#include <iostream>
#include <string>
using namespace std;

string s;
string ans = "~";//아스키코드상으로 z보다 큼

int main() {
	cin >> s;

	//0~i, (i+1) ~ j, j+1 ~ s.size()-1 
	for (int i = 0; i <= s.size() - 3; i++) {
		for (int j = i + 1; j <= s.size() - 2; j++) {
			string temp;
			//첫번째 삼등분한 파트를 뒤에서부터 temp배열에 더함
			for (int x = i; x >= 0; x--) {
				temp += s[x];
			}

			for (int y = j; y > i; y--) {
				temp += s[y];
			}

			for (int z = s.size()-1; z > j; z--) {
				temp += s[z];
			}

			if (ans > temp) ans = temp;
		}
	}
	
	cout << ans;

	return 0;
}