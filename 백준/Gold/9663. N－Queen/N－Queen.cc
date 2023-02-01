#include <iostream>
#include <cmath>

using namespace std;

int cnt = 0;
int n;
int chess[15];

bool promising(int x) {
	for(int i =0; i < x; i++) {
		if (chess[x] == chess[i] || (abs(chess[x] - chess[i]) == abs(x - i)))
			return false;
	}
	return true;
}

void solution(int x) {

	if (x == n) {
		cnt++;
		return;
	}

	else {
		for (int i = 0; i < n; i++) {
			chess[x] = i;
			if (promising(x)) solution(x + 1);
			}
	}
}

int main() {
	cin >> n;
	solution(0);
	cout << cnt;
	
}