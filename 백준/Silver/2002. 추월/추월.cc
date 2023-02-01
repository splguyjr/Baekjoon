#include <iostream>
#include <deque>
#include <string>
#include <vector>

using namespace std;

deque<string> daegun;
deque<string> youngsik;
int n;
string car;
int cnt=0;

vector<string> lst(string a, deque<string> b) {
	vector<string> v;
	while(!b.empty()) {
		if (b.front() == a) {
			b.pop_front();
			while (!b.empty()) {
				v.push_back(b.front());
				b.pop_front();
				
			}
			return v;
		}

		else b.pop_front();
	}
}


int main() {
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> car;
		daegun.push_back(car);
	}

	for (int i = 0; i < n; ++i) {
		cin >> car;
		youngsik.push_back(car);
	}

	string temp;
	int a = n - 1;

	while (a--); {

	deque<string> dq1(daegun);
	deque<string> dq2(youngsik);
	vector<string> v;

	vector<string> dae_car_num;
	dae_car_num.push_back(dq1.front());
	dq1.pop_front();//처음 들어간 차량은 추월불가
	
	while(!dq1.empty()) {
		temp = dq1.front();
		v = lst(temp, dq2);

		bool br = false;
		for (int i = 0; i < v.size(); ++i) {
			for (int j = 0; j < dae_car_num.size(); ++j) {
				
				if (dae_car_num[j] == v[i]) { cnt++; br = true; break; }
			}
			if (br) break;
		}

		dae_car_num.push_back(temp);
		dq1.pop_front();

	}

	}

	cout << cnt;
	return 0;
}