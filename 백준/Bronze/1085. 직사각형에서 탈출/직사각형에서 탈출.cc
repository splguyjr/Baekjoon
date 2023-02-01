#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int a, b;//오른쪽 위 꼭짓점
	int x, y;

	int from_x, from_y, from_a, from_b;

	cin >> x >> y >> a >> b;

	from_x = y;
	from_y = x;
	from_a = a - x;
	from_b = b - y;
	
	int ans = min( {from_x, from_y, from_a, from_b} );
	cout << ans;


	return 0;
}