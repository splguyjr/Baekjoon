#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	string s;
	string word[1000];
	cin >> s;
	int a = s.length();
	
	for(int i=0; i<a; i++){
		word[i] = s.substr(i, a);
	}
	
	sort(word, word+a);
	
	for(int i=0; i<a; i++){
		cout << word[i] << endl;
	}
	
}