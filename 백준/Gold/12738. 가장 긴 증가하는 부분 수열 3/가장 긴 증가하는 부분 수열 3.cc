#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000001];
int len, n;

int main() {
    ios_base::sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        int here;
        cin >> here;
        auto pos = lower_bound(arr, arr + len, here);
        *pos = here;
        if (pos == arr + len)
            len++;
    }

    cout << len;
    
    return 0;
}
