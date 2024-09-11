#include <iostream>


using namespace std;

char arr[21][21];
int r, c;
int dx[4] = { -1, 0 ,0, 1 };
int dy[4] = { 0, 1, -1, 0 };
bool visited[26];
int ans;

int mx(int x, int y) 
{
	int result = (x > y) ? x : y;
	return result;
}

//보드 알파벳 입력
void input() 
{
	cin >> r >> c;

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> arr[i][j];
		}
	}
}

//dfs + 백트래킹, 이미 방문한 곳이 아니라면 진행, 이미 방문했다면
void dfs(int x, int y, int cnt) 
{
	ans = mx(ans, cnt);

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if(nx>=0 && ny>=0 && nx <r && ny <c) {
			if (!visited[arr[nx][ny] - 'A']) {
				visited[arr[nx][ny] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				visited[arr[nx][ny] - 'A'] = false;
			}
		}
	}
}

void solution() 
{
	visited[arr[0][0] - 'A'] = true;
	dfs(0, 0, 1);

	cout << ans;
}

int main() 
{	
	input();
	solution();

	return 0;
}