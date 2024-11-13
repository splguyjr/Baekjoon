#include <iostream>

using namespace std;


string arr[101] = { "impossible","BA", "BBA", "impossible" };//arr[0]이 n=1에 대응
//n=2일 때 1,1
//n=3일때 1,1/2로 가능
//이후 피보나치 수열의 특성에 의해 n+3에 대하여 BBA의 형식으로 가능(연속된 피보나치 수열 3개 중 앞선 2개가 B)



int main() {
	for (int i = 0; i < 97; i++) {
		if (arr[i] == "impossible") {
			arr[i + 3] = "impossible";
		}
		else {
			arr[i + 3] = arr[i] + "BBA";
		}
	}

	int t;

	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		cout << arr[n - 1] << '\n';
	}

	return 0;
}