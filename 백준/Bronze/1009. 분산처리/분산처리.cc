#include <iostream>
using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	int a,b,n,temp;
	
	cin >> n;
	for(int i =0; i < n; i++) {
		cin >> a >> b;
		temp = a;
        while(b>4) {
            b-=4;
        }
		for(int j=1; j<b; j++) {
			a = a*temp;
			while(a >10) {
				a-=10;}
		}
		while(a>10)
			a-=10;
		cout << a << '\n';
	}
	return 0;
}