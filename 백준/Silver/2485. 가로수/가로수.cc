#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int gc(int a, int b) {
	int c = a%b;
	while(c!=0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}



int main() {
	int n;
	cin >> n;
	vector<int> tree;
	vector<int> distance;
	
	//tree 벡터에 모든 가로수 위치 넣기
	int num = 0;
	for(int i =0; i < n; i++) {
		int a;
		cin >> a;
		tree.push_back(a);
		
	}
	//tree 벡터 크기순으로 정렬
	sort(tree.begin(), tree.end());

	for(int i =1; i <n; i++) {
	distance.push_back(tree[i]- tree[i-1]);
	}
	
	int gcd= distance[0];
	
	for(int i =1; i<n-2; i++) {
		gcd = gc(gcd, distance[i]);
	}
	
	int min = (tree[n-1]-tree[0])/gcd;
	min -= n-1;
	

	cout << min;
	
	return 0;
	
}