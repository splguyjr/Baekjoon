#include <iostream>
#include <vector>

using namespace std;

int main() {
	long long int n, w;
	long long int count=0, remain=0;
	int coin_price;
	vector<int> price;

	cin >> n >> w;
	while (n--) {
		cin >> coin_price;
		price.push_back(coin_price);
	}

	long long int temp;
	for (int i = 0; i < price.size() - 1; ++i) {
		long long int p1 = price[i];
		long long int p2 = price[i + 1];
		
		if (count != 0) {
			w = count * p1 + remain;
			count = 0;
			remain = 0;
		}

		if (p1 < p2) {
			count = w / p1;
			remain = w % p1;
		}
		temp = p2;
	}
	
	if(count !=0) w = count * temp + remain;

	cout << w;
}