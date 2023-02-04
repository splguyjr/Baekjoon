#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int arr[101];
vector<int> plug;
int ans = 0;
int n, k;

int main() {
	cin >> n >> k;
	
	int temp;
	for (int i = 0; i < k; i++) {
		cin >> arr[i];
		
		if (i !=0 && n == 1) {
			if (temp == arr[i]) {
				ans -= 1;
			}
		}
		temp = arr[i];
	}
	
	if (n == 1) {
		ans += k-1;
		cout << ans;
		return 0;
	}
	

	for(int i =0;i <k; i++) {
		vector<int> plug2;
		int cnt = 0;

		if (plug.size() < n) {
			if (find(plug.begin(), plug.end(), arr[i]) != plug.end()) {
				continue;
			}
			plug.push_back(arr[i]);
			continue;
		}


		bool check = false;
		for (int j = i + 1; j < k; j++) {
			for (int x = 0; x < n; x++) {
				if (find(plug.begin(),plug.end(), arr[i]) != plug.end()) {
					check = true; 
					break;
				}
				if (plug[x] == arr[j]) {
					
					if (find(plug2.begin(), plug2.end(), arr[j]) != plug2.end()) {
						break;
					}
					
					plug2.push_back(arr[j]);
//					cout << arr[j] << endl;
					cnt++;
					break;
				}
			}
			if (check || cnt == n - 1) break;
		}

		if (find(plug.begin(), plug.end(), arr[i]) != plug.end()) check = true;
		
		if(!check) {
			while (plug2.size() != n - 1) { plug2.push_back(0); }
		plug2.push_back(arr[i]);
//		cout << arr[i] << endl;
		plug = plug2;
		ans++;
		}
//		cout << endl;
	}

	cout << ans;

	return 0;
}