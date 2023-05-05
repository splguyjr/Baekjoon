#include <iostream>
#include <queue>
#include <cstring>
#include <tuple>

using namespace std;


int l, r, c;
bool visited[31][31][31];
int dx[6] = { -1,0,0,1,0,0};
int dy[6] = { 0,1,-1,0,0,0 };
int dz[6] = { 0,0,0,0,1,-1 };
char arr[31][31][31];
int ans = 0;
bool flag;//E발견시 bfs종료

void bfs(int d, int e, int f, int cnt) {
	flag = true;
	queue<tuple<int,int,int,int>> q;
	q.push({ d,e,f,cnt });
	visited[d][e][f] = true;
	

	while (!q.empty() && flag) {
		
		int x = get<0>(q.front());
		int y = get<1>(q.front());
		int z = get<2>(q.front());
		int w = get<3>(q.front());
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z + dz[i];
			int nw = w + 1;
			if (nx < 0 || ny < 0 || nz<0 || nx >= r || ny >= c || nz >= l) continue;

			if (!visited[nx][ny][nz]) {
				visited[nx][ny][nz] = true;

				if (arr[nx][ny][nz] == 'E') {
					cout << "Escaped in " << nw << " minute(s)." << '\n';
					flag = false;
					break;
				}
				if (arr[nx][ny][nz] == '.') {
					q.push({ nx,ny,nz,nw });
				}

			}
		}
		if (!flag) break;
	}
}

int main() {

	int t1, t2, t3;
	//l층 r행 c열
	//i   j   k
	//z   x   y

	while(true) {
	cin >> l >> r >> c;
	if (l == 0 && r == 0 && c == 0) break;

	for (int i = 0; i < l; i++) {
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				cin >> arr[j][k][i];
				if (arr[j][k][i] == 'S') {
					t1 = j; t2 = k; t3 = i;
				}
			}
		}
	}

	bfs(t1, t2, t3,0);
	
	if (flag) cout << "Trapped!" << endl;
	flag = true;
	memset(visited, false, sizeof(visited));

	}



	return 0;
}