#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int mx[10001];//매장별 최대 누적매출 기록
int sum[301][10001];//직원번호, 맡은 매장 번호
vector<int> v[10001];//직원이 맡는 매장 번호를 쭉 가짐
int king[10001];//해당 매장에서 1위인 직원의 번호 저장
int king_num[301];//각 직원이 매출 1위인 매장의 수
int n, m, k;//직원 수, 총 매장 수, 맡은 매장 수
int q;
int cnt = 0;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
	cin >> n >> m >> k;

	int a, b;
	

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < k; j++) {
			cin >> a >> b;
			sum[i][a] = b;
			if (mx[a] < b) {
				if (mx[a] == 0) {
					king_num[i]++;
				}
				else {
					king_num[i]++;
					king_num[king[a]]--;
				}
				mx[a] = b;
				king[a] = i;
			}
			v[i].emplace_back(a);
		}
	}

	cin >> q;

	int e, f, g;

	for (int i = 1; i <= q; i++) {
		cin >> e >> f >> g;//직원 번호, 매장 번호, 매출 증가액

		sum[e][f] += g;
		if (sum[e][f] > mx[f]) {
			mx[f] = sum[e][f];
			king_num[e]++;
			king_num[king[f]]--;
			king[f] = e;
		}

		cnt = 0;
		for (int j = 1; j <= n; j++) {
			if (king_num[j] == k) {
				cnt++;
			}
		}
		cout << cnt << '\n';
	}
	return 0;
}