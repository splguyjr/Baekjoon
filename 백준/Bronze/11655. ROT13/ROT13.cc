#include <iostream>
#include <string>
using namespace std;

int main() {
	
	string ch;
	getline(cin, ch);
	char c;
	
	for (int i =0; i < ch.size(); i++) {
		if((ch[i] >= 'A' && ch[i] <= 'M') || (ch[i] >= 'a' && ch[i] <= 'm'))
			c = ch[i] + 13;
		else if((ch[i] >= 'N' && ch[i] <= 'Z') || (ch[i] >= 'n' && ch[i] <= 'z'))
			c = ch[i] - 13;
		else
			c = ch[i];
		cout << c;
	}
	

}