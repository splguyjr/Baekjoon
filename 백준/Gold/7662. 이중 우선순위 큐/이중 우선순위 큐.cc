#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int t, n;

bool visited[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	while (t--) {

		//그냥 int가 아닌 pair<int,int>로 해주는 이유: pq에서 해당 숫자가 이미 빠졌는지
		//판단하는 bool visited배열과의 동기화를 맞추기 위해서는 입력된 순서도 함께 받아줘야 함.
		//한쪽 pq에서 pop이 일어나고 난뒤 다른 쪽에 있는 pq에서 그 해당 숫자를 unvalid로 판단하는 것을 가능하게 해줌.

		priority_queue<pair<int, int>> pq1;//MaxHeap
		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq2;//MinHeap

		cin >> n;
	
		for (int i = 0; i < n; i++) {
			char op;
			int num;
			cin >> op >> num;

			if (op == 'I') {
				pq1.push({ num,i });
				pq2.push({ num,i });
				visited[i] = true;
			}

			else {
				if (num == 1) {
					while (!pq1.empty() && !visited[pq1.top().second]) {
						pq1.pop();
					}

					if(!pq1.empty()) {
					visited[pq1.top().second] = false;
					pq1.pop();
					}

				}

				else {
					while (!pq2.empty() && !visited[pq2.top().second]) {
						pq2.pop();
					}

					if (!pq2.empty()) {
						visited[pq2.top().second] = false;
						pq2.pop();
					}
				}
			}
		}

		
		//한번 더 해주는 이유: 마지막으로 숫자가 빠진 쪽 heap의 top에 이미 반대 heap에서 빠진 숫자가 올 수 있음.
		while (!pq1.empty() && !visited[pq1.top().second]) {
			pq1.pop();
		}

		while (!pq2.empty() && !visited[pq2.top().second]) {
			pq2.pop();
		}
	

		if (pq1.empty()) {
			cout << "EMPTY\n";
		}

		else {
			cout << pq1.top().first << " " << pq2.top().first << '\n';
		}
		

	}


	return 0;

}