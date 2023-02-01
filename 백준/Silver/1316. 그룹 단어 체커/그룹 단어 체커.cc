#include <iostream>
#include <string>
using namespace std;

int main() {
	int N;
	cin >> N;
	
	bool check = true;
	int count = N;
	string word;
	
	while(N--) {
		cin >> word;
		for(int i = 0; i <word.length(); i++) {
			if(word[i] != word[i+1]) {
				for(int j= i+1; j< word.length(); j++) {
					if(word[i] == word[j]) {
						count--;
						goto stop;
					}
				}
			}
			
		}
		stop:;
	
	}
	
	cout <<count;
	return 0;
}