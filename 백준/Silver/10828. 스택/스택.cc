#include <iostream>
#include <string>
#include <vector>

using namespace std;

int n;
string command;
vector<int> vec;

void push() {
	int a;
	cin >> a;
	vec.push_back(a);

}

void pop() {
	if (vec.size() >= 1) {
		cout << vec.back() << '\n';
		vec.pop_back();
	}
	else {
		cout << "-1" << '\n';
	}
	
}

void size() {
	cout << vec.size() << '\n';
}

void empty() {
	if (vec.empty()) {
		cout << "1" << '\n';
		return;
	}
	cout << "0" << '\n';
}

void top() {
	if (vec.size() >= 1) {
		cout << vec.back() << '\n';
	}
	else {
		cout << "-1" << '\n';
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;
	while (n--) {
		cin >> command;

		if (command == "push") {
			push();
		}
		else if (command == "pop") {
			pop();
		}
		else if (command == "size") {
			size();
		}
		else if (command == "empty") {
			empty();
		}
		else if (command == "top") {
			top();
		}
	}


	return 0;
}