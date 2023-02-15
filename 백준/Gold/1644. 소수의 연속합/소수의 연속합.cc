#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int n;
int prime[4000001];
vector<int> v;
int p1 = 0, p2 = 0;
int sum = 0;//투포인터로 이동하면서 sum과 n값 비교에 따라 p1,p2조작하여 끝 인덱스까지 이동
int cnt = 0;//연속된 소수의 합으로 나타낼 수 있는 경우 count


//prime 배열에 n까지 소수 구하는 함수, 해당 인덱스 저장값이 1이면 합성수 0이면 소수
void fill_prime(int n) {
	for (int i = 2; i <= sqrt(n); i++) {
		for (int j = i * i; j <= n; j += i) {
			if (prime[j]) continue;
			prime[j] = 1;
		}
	}
}


int main() {
	cin >> n;

	if (n <= 3) {
		if (n == 1) cout << 0;
		else if (n == 2) cout << 1;
		else if (n == 3) cout << 1;
		return 0;
	}

	fill_prime(n);

	//n이하의 소수들 v에 저장
	for (int i = 2; i <= n; i++) {
		if (!prime[i]) v.push_back(i);
	}

	while(p2 < v.size()) {

	if (sum < n) {
		sum += v[p2++];
	}
	else if (sum >= n) {
		if (sum == n) {
			cnt++;
			sum += v[p2++];
			sum -= v[p1++];
			continue;
		}
		sum -= v[p1++];
	}


	}
	
	if (sum - v[p1] == n) {
		cnt++;
	}


	cout << cnt;

	return 0;
}