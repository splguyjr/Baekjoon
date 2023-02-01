#include <iostream>
#include <stack>
using namespace std;

int main() {
	stack<int> check;
	int n;
	cin >> n;
	int num;
	int max =0;
	
	
	char memory[201000];
	int loc=0;
	for (int i=0; i< n; i++) {
		cin >> num;
		if(num > max) {
			for(int j = max+1; j<= num; j++) {
				check.push(j);
				memory[loc++] = '+';
				
			}
		}
		else {
			if(check.top() != num) {
				cout << "NO";
				return 0;
			}
			
		}
		check.pop();
		memory[loc++] = '-';
		
		if (max < num)
			max = num;
			
		
		
	}
	for (int i = 0; i<loc;i++)
		cout << memory[i] << '\n';
	return 0;
}