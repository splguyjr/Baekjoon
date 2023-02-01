#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct student{
	string name;
	int lang, eng, math;
};

bool compare(student a, student b) {
	if(a.lang == b.lang && a.eng == b.eng && a.math == b.math) return a.name < b.name;
	if(a.lang == b.lang && a.eng == b.eng) return a.math>b.math;
	if(a.lang == b.lang) return a.eng<b.eng;
	return a.lang > b.lang;
}

int main() {

	int N;
	cin >> N;
	vector<student> v(N);
	for (int i = 0; i< N; i++) {
		cin >> v[i].name >> v[i].lang >> v[i].eng>>v[i].math;
	}
	sort(v.begin(), v.end(), compare);
	for(int i = 0 ; i <N; i ++) cout <<v[i].name<<'\n';
	
	
	return 0;
}