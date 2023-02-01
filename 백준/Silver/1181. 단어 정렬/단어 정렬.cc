#include <iostream>
#include <string>
#include <algorithm>
#include <set>
#include <vector>


using namespace std;


bool compare(const string& a, const string& b) {
	if (a.size() == b.size()) {
		return a < b;
	}
	else
		return a.size() < b.size();
}
int n;
vector<string> v;



//struct compare {
//	bool operator () (const string& a, const string& b) const{
//		if (a.size() == b.size()) {
//			return a < b;
//		}
//		else
//			return a.size() < b.size();
//	}
//
//};

int main() {
	ios::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	//set<string, compare> s;
	
	cin >> n;
	
	string temp;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		//s.insert(temp);
		v.push_back(temp);
	}

	sort(v.begin(), v.end(), compare);
	v.erase(unique(v.begin(), v.end()), v.end());


	for (auto str : v) {
		cout << str << '\n';
	}
	/*for (auto str : s) {
		cout << str << '\n';
	}*/



	return 0;
	
	
}