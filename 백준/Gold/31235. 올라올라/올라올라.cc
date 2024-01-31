#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	
	int prev = arr[1];//직전까지 최대 저장
	int prev_idx = 1;//직전까지 최대 위치
	int k = 1;
	
	for (int i = 1; i <= n; i++) {
		int mx = 0;//i~i+k-1 중 최대를 저장
		if (i + k - 1 > n) break;

		int temp_idx = 0;
		
		if (prev_idx != i - 1) {//이전 최대위치가 i-1이 아니라면 기존 최댓값 그대로 이용
			mx = prev;
		}
		
		if (arr[i + k - 1] >= prev) {//새로 구간에 들어온 맨 오른쪽 수가 기존 최대보다 큰지 확인
			prev_idx = i + k - 1;
			prev = arr[i + k - 1];
			continue;
		}


		while (mx < prev && i + k - 1 <= n) {//mx =0인 상태로 들어오게 됨
			mx = arr[i + k - 1];
			if (mx >= prev) {
				prev_idx = i + k - 1;
				prev = mx;
				break;
			}
			k++;
		}

	}
	
	cout << k;

	return 0;
}



/*if (prev_idx == i - 1) {//이전 최대가 i-1이 이었을 경우 i~i+k-1까지 돌며 최대 구하기
			for (int j = 1; j <= k; j++) {
				if(arr[i+j-1]>mx) {
					mx = arr[i + j - 1];
					temp_idx = i + j - 1;
				}
			}
			if (mx >= prev) {
				prev = mx;
				prev_idx = temp_idx;
				continue;
			}
		}

		else {
			mx = prev;
		}*/