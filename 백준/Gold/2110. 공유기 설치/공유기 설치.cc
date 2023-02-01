#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int n, c;
int x;
int lt, rt;
int mx = 0;//최대
int mn = 1000000000;//최소
int ans = 1;
vector<int> v;

int main() {
	cin >> n;
	cin >> c;
	while (n--) {
		cin >> x;
		if (x > mx) {
			mx = x;
		}
		if (mn > x) mn = x;
		v.push_back(x);
	}

	sort(v.begin(), v.end());

	lt = 1;
	rt = (mx - mn) / (c - 1); //처음부터 마지막까지 거리를 c-1로 나눴을때 최대

	

	while(rt >= lt) {

	int cnt = 0;

	//cout << lt << ' ' << rt << endl;
	int mid = (rt +lt) / 2;
	//cout << "mid : " << mid << endl;
	int temp = mn;
	
	for (int i = 0; i < v.size(); ++i) {
		if (v[i] - temp >= mid) {
			//cout << v[i] << " "<< temp << endl;
			temp = v[i];
			cnt++;
		}
	}
	
	//cout << "cnt : " << cnt << "  c-1:  " << c - 1 << endl;

	if (cnt >= c-1) { 
		ans = mid;
		lt = mid + 1; 
	
	}
	else {
		rt = mid - 1;
	}

	
	}

	cout << rt;


}