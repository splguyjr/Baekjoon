#include <iostream>

using namespace std;

int tree[26][2];
char a, b, c;
int n;

void preorder(int x) {
	if (x == -1) return;
	cout << char(x + 'A');
	preorder(tree[x][0]);
	preorder(tree[x][1]);
	
}

void inorder(int x) {
	if (x == -1) return;
	inorder(tree[x][0]);
	cout << char(x + 'A');
	inorder(tree[x][1]);

}

void postorder(int x) {
	if (x == -1) return;
	postorder(tree[x][0]);
	postorder(tree[x][1]);
	cout << char(x + 'A');
	
	


}


int main() {
	cin >> n;
	while (n--) {
		cin >> a >> b >> c;
		if (b == '.') {
			tree[a - 'A'][0] = -1;
		}
		else {
			tree[a - 'A'][0] = b-'A';
		}
		if (c == '.') {
			tree[a - 'A'][1] = -1;
		}
		else {
			tree[a - 'A'][1] = c-'A';
		}
		

	}

	preorder(0);
	cout << '\n';
	inorder(0);
	cout << '\n';
	postorder(0);

	return 0;
}