#include <iostream>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

map<string, int> book;

int main() {
	int n;
	cin >> n;
	int Max;
	string name;
	
	while(n--) {
		cin >> name;
		book[name]++;
	}
	
	for(auto i = book.begin(); i!=book.end(); i++) {
		Max = max(Max, i->second);
	}
	
	for(auto i = book.begin(); i!=book.end(); i++) {
		if(Max == i->second) {
			cout << i->first;
			return 0;
		}
	}
	
	return 0;
}