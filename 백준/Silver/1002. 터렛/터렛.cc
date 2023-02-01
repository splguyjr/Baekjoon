#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int x1, x2, r1, y1, y2, r2;
	
	int num;
	
	cin >> num;
	
	while(num--) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		
		int d;
		d = pow((x2-x1),2) +pow((y2-y1),2);
		
		
		if(sqrt(d) > r1 + r2) cout <<0<<'\n';
		
		else if (d == pow((r1 + r2),2)) cout << 1 <<'\n';
		
		else if (abs(r1-r2) < sqrt(d) && sqrt(d)< r1+r2) {
			cout << 2 <<'\n';
		}
		
		else if (sqrt(d) <= abs(r1- r2)) {
			
			if(d==pow((r1 - r2),2)) {
				
				if(d ==0) cout << -1<<'\n';
				
				else {cout << 1<<'\n';}
		
			}
			else  cout << 0 <<'\n';
		}
		
	}
		

	return 0;
}