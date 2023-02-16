#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define X first
#define Y second
typedef pair<int, int> pii;

int n;
int parent[3001];
pair<pii, pii> line[3001];
int cnt[3001];

int getParent(int a) {
	if (parent[a] == a) return a;
	return parent[a] = getParent(parent[a]);
}

void Union(int a, int b) {
	parent[getParent(a)] = getParent(b);
}

int CCW(pii a, pii b, pii c) {
	int check = b.X * c.Y + a.Y * c.X + a.X * b.Y - b.Y * c.X - a.X * c.Y - a.Y * b.X;

	if (check > 0) return 1;
	else if (check < 0) return -1;
	else return 0;
}

bool intersect(pii a, pii b, pii c, pii d) {
	int check1 = CCW(a, b, c) * CCW(a, b, d);
	int check2= CCW(c, d, a) * CCW(c, d, b);

	if (check1 <= 0 && check2 <= 0) {
		if (check1 == 0 && check2 == 0) {
			if (b <= a) swap(a, b);
			if (d <= c) swap(d, c);

			return b >= c && d >= a;
		}
		return true;
	}
	return false;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> line[i].X.X >> line[i].X.Y >> line[i].Y.X >> line[i].Y.Y;
		parent[i] = i;
	}


	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (intersect(line[i].X, line[i].Y, line[j].X, line[j].Y)) {
				Union(i, j);
			}
		}
	}

	

	for (int i = 0; i < n; i++) {
		cnt[getParent(i)]++;
	}

	int group = 0, mx = 0;
	for (int i = 0; i < n; i++) {
		if (cnt[i] > 0) group++;
		
		mx = max(mx, cnt[i]);
	}

	cout << group << '\n' << mx;

	return 0;
}