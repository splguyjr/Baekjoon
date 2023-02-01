#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class person{
	public:
	int age;
	string name;
};

bool compare(person a, person b) {
	return a.age < b.age;
}
person *p = new person[100001];

int main() {
	int n;
	cin>> n;
	
	for(int i =0; i < n; ++i) {
		cin >> p[i].age >> p[i].name;
	}
	
	stable_sort(p, p+n, compare);
	
	for(int i = 0; i < n; ++i) {
		cout << p[i].age << " " << p[i].name << '\n';
	}
		return 0;
}