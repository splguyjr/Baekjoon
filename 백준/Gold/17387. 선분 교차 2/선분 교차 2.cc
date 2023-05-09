#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;

struct Point {
	ll x;
	ll y;
	bool operator<=(Point const& p1) {
		if (x == p1.x) {
			return y <= p1.y;
		}
		return x <= p1.x;
	}
};

ll CCW(Point A, Point B, Point C) {
	ll res = A.x * B.y + B.x * C.y + C.x * A.y - B.x * A.y - C.x * B.y - A.x * C.y;

	if (res > 0) return 1;

	else if (res < 0) return -1;

	return 0;
}

int main() {
	Point A, B, C, D;

	cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y >> D.x >> D.y;

	ll ABC = CCW(A, B, C);
	ll ABD = CCW(A, B, D);
	ll ACD = CCW(A, C, D);
	ll BCD = CCW(B, C, D);

	ll check1 = ABC * ABD;
	ll check2 = ACD * BCD;

	//abcd
	if (check1 <= 0 && check2 <= 0) {
		if (check1 == 0 && check2 == 0) {
			if (B <= A) {
				swap(A, B);
			}
			if (D <= C) {
				swap(C, D);
			}
			
			if (C <= B && A <= D) {
				cout << 1;
			}
			else cout << 0;
		}

		else cout << 1;
	}

	else cout << 0;

	return 0;
}