#include <iostream>
#include <algorithm>
using namespace std;

bool BinarySearch(long int *arr, long int first, long int last, long int key)  {
	if(first>last) return false;
	long int mid = (first + last) /2;
	if(arr[mid]== key) return true;
	else if(arr[mid] > key) {
		return BinarySearch(arr, first, mid-1, key);
	}
	else return BinarySearch(arr, mid+1, last, key);
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, M;
	
	cin>> N;
	long int lst[N];
	
	//크기 N의 배열에 넣기
	for(int i = 0; i<N; i++) {
		long int temp;
		cin >> temp;
		lst[i] = temp;
	}
	
	//정렬하기
	/*	for(int i=0; i<N-1;i++) {
		for(int j =0; j<N-i-1; j++) {
			
			if(lst[j] > lst[j+1]) {
				long int temp;
				temp = lst[j];
				lst[j] = lst[j+1];
				lst[j+1] = temp;
			}
			
		}
	}*/
	sort(lst,lst+N);
	
	cin >> M;
	
	for(int i =0; i<M; i++) {
		int num;
		cin >> num;
		
		if(BinarySearch(lst, 0, N-1, num)) cout << 1 <<'\n';
		
		else { cout <<0<<'\n';}
		
	}
	
	return 0;
}