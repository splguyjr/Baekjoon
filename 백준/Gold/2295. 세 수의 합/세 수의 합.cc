#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int arr[1001];
vector<int> v_sum;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	//집합 U내의 원소 2개로 만들 수 있는 합을 벡터에 담음
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			v_sum.push_back(arr[i] + arr[j]);
		}
	}

	//큰 수부터 검색하기 위해 내림차순 정렬
	sort(arr, arr + n, greater<int>());
	sort(v_sum.rbegin(), v_sum.rend());


	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			int tmp = arr[i] - arr[j];
			//binary_search에서는 오름차순 정렬이 기본이므로 내림차순되어있는걸 끝에서부터 읽으면 오름차순
			if (binary_search(v_sum.rbegin(), v_sum.rend(), tmp)) {
				cout << arr[i] << endl;
				return 0;
			}
		}
	}



	return 0;
}