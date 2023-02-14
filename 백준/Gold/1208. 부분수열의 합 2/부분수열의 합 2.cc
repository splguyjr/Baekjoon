#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int n, s;
vector<int> v;
int half;
long long ans;
map<int, int> m;

//0~half-1범위의 부분수열 합 dfs
void dfsLeft(int idx, int sum) {
	if (idx == half) {
		m[sum]++; return; //왼쪽 절반을 dfs하여 나온 각각의 sum을 key로 map에 저장.
	}
	dfsLeft(idx + 1, sum);//부분수열에 포함 x -> 아예 전부 다 안 포함시키는 경우까지 dfs
	dfsLeft(idx + 1, sum + v[idx]);//해당 idx 부분수열에 포함시키는 경우
}

void dfsRight(int idx, int sum) {
	if (idx == n) {
		ans += m[s - sum]; return;
	} // 이전에 dfsLeft에서 구했던 sum의 합과 합쳤을 때 s가 되도록
	//s-rightsum = leftsum을 만족하는 경우에 ans+=1;
	dfsRight(idx + 1, sum);
	dfsRight(idx + 1, sum+v[idx]);

}



int main() {
	
	cin >> n >> s;

	half = n / 2;
	v.resize(n);

	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	dfsLeft(0, 0);
	dfsRight(half, 0);

	if (s == 0) ans--;
	cout << ans;



	

	return 0;
}
//https://life-with-coding.tistory.com/305
//map을 활용해서 아름답게 푸는 풀이, 나는 부분수열 구현부터 해매고 앉아있었다..