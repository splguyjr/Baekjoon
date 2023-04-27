#include <iostream>

using namespace std;

int N, m, M, T, R;
//운동을 N분 최소맥박 m 최대맥박 M 1분에 증가맥박 T 1분에 쉬는 맥박 R, 
int main() {
	cin >> N >> m >> M >> T >> R;

	int temp = m;
	int ans = 0;

	if (M - m < T) {
			cout << -1;
			return 0;
		}
	while (N--) {
		
		if (temp + T > M) {
			
			temp -= R;
			if (temp < m) {
				temp = m;
			}
			N++;
		}
		
		else {
			temp += T;
		}
		ans++;
	}

	cout << ans;

	return 0;
}