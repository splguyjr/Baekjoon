#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>

using namespace std;

string p, f;
int n;
int arr[101][101];

int check(int pi, int fi) {
	int& res = arr[pi][fi];

	if (res != -1) 
		return res;

	if (pi < p.size() && fi < f.size() && p[pi] == f[fi])
		return res = check(pi + 1, fi + 1);

	if (pi == p.size() && fi == f.size())
		return res = 1;


	//1. p의 pi번째 인덱스가 *일 때, 그냥 바로 pi+1번째 인덱스로 넘기기(*와 아무것도 매칭 x)
	//2. f의 fi번째 인덱스를 *과 매칭시키기(이때, f.size()보다 커질 경우를 검사, 아니면 무한 루프)
	if (p[pi] == '*')
		return res = (check(pi + 1, fi)) || (fi < f.size() && check(pi, fi + 1));

	return 0;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> p >> n;

	while (n--) {
		cin >> f;

		memset(arr, -1, sizeof(arr));

		if (check(0, 0)) cout << f << '\n';
	}

	return 0;
}