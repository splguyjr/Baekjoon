#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N;
	cin >> N;
	
	int lst[N];
	
	int temp;
	for (int i =0; i<N; i++)
	 {
	 	cin>> temp;
	 	lst[i] = temp;
	 }
	 
	 int scan, min=1000000;
	 for(int i = 0; i<N; i++) {
	 	int index;
	 for (int i = 0; i<N; i++) {
	 	
	 	if(lst[i]<scan) {
	 		scan = lst[i];
	 		index = i;
	 	}
	 }
	 min = scan;
	 lst[index] = 10000000;
	 scan = 10000000;
	 cout << min<<endl;
	}
	 
	return 0;
}