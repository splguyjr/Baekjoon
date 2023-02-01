#include <iostream>
#include <stack>

using namespace std;

stack<pair<int,int>> st;
int n;

int laser(int a) {
	int ans = 0;
	st.pop();
	while (!st.empty()) {
		if (st.top().second >= a) {
			ans = st.top().first;
			break;
		}
		else st.pop();
	}

	return ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int cnt = 1;
	while (n--) {
		int h;
		cin >> h;
		st.push({cnt, h});
		cout << laser(h) << " ";
		st.push({ cnt, h });
		cnt++;
	}

	return 0;
}