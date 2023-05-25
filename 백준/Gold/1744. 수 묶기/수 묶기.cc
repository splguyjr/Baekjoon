#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> p;//양수
vector<int> z;//0
vector<int> m;//음수
int sum = 0;

bool check(vector<int> v) {

	if (v.size() % 2 == 0) return true;
	else return false;

}

int main() {

	cin >> n;

	int temp;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp > 0) p.push_back(temp);
		else if (temp < 0) m.push_back(temp);
		else { z.push_back(temp); }
	}

	sort(p.rbegin(), p.rend());//양수 내림차순 정렬, 5 4 3..
	sort(m.begin(), m.end());//음수 오름차순 정렬, -5 -4 -3..


	for (int i = 0; i < p.size() / 2; i++) {
		if (p[2 * i] + p[2 * i + 1] > p[2 * i] * p[2 * i + 1]) {
			sum += p[2 * i] + p[2 * i + 1];
			continue;
		}
		sum += p[2 * i] * p[2 * i + 1];
	}

	if(!check(p)) sum += p[p.size() - 1];


	for (int i = 0; i < m.size() / 2; i++) {
		sum += m[2 * i] * m[2 * i + 1];
	}

	if(!check(m)) {
		if(z.size() == 0) sum += m[m.size() - 1];
	}

	cout << sum;


	return 0;
}