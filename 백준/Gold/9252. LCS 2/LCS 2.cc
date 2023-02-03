#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

string a, b;
int dp[1001][1001];

int main() {
	cin >> a >> b;

	for (int i = 0; i < a.size(); i++) {
		for (int j = 0; j < b.size(); j++) {
			if (a[i] == b[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
			}

			else {
				dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
	}
	
	int len = dp[a.size()][b.size()];
	cout << len << '\n';
	
	/*if (dp[a.size()][b.size()] == 0) return 0;*/
	
	
	int i = a.size();
	int j = b.size();
	stack<char> s;
	while (len) {
		
		if (dp[i][j] == dp[i - 1][j]) {
			i--;
		}
		else if (dp[i][j] == dp[i][j-1]) {
			j--;
		}
		else {
			s.push(a[i - 1]);
			i--; j--; len--;
			
		}
	}
	
	while (!s.empty()) {
		cout << s.top();
		s.pop();
	}
	
		
	return 0; 
}