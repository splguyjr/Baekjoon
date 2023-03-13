#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int n;
vector<int> v;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	
	int x;

	for (int i = 0; i < n; i++) {
		cin >> x;
		v.push_back(x);
	}
	vector<int> v1;
	v1 = v;

	sort(v1.begin(),v1.end());
	v1.erase(unique(v1.begin(), v1.end()), v1.end()); //v1의 중복 요소들을 뒤로 보낸 뒤 그 시작지점부터 끝까지 삭제

	for (int i = 0; i < n; i++) {
		cout << lower_bound(v1.begin(), v1.end(), v[i]) - v1.begin() << " ";
	}



	return 0;
}