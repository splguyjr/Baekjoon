#include <iostream>
#include <algorithm>

using namespace std;

int real_arr[1000001];
int arr[1000001];
int index[1000001];
int len, n;

int main() {
    ios_base::sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int here;
        cin >> here;
        real_arr[i] = here;
        auto pos = lower_bound(arr + 1, arr + len + 1, here);
        *pos = here;
        index[i] = pos - arr;
       
        if (pos == arr + len + 1)
            len++;
    }

    cout << len << '\n';
    
    int temp = len;

    for (int i = n; i >= 1; i--) {
        if (!len) break;

        if (index[i] == len) {
            arr[len] = real_arr[i];
            len--;
        }

    }

    for (int i = 1; i <= temp; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
