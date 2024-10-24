#include <iostream>

using namespace std;

int n;
int arr[100001];
bool cnt[100001];
long long ans;

void input() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
}

void solve() {	
	int ed = 0;
	for (int st = 0; st < n; st++) {
		while (ed < n) {
			if (cnt[arr[ed]]) break;//현재 수열의 맨 마지막 숫자가 이미 앞에 있었을 경우
			else {
				cnt[arr[ed]] = 1;
				ed++;
			}
		}
		ans += (ed - st);
		cnt[arr[st]] = 0;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	input();
	solve();

	cout << ans;

	return 0;
}
