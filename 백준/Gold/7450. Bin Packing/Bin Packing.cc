// BOJ # 7450. Bin Packing (가방 꾸리기 문제)

#include <iostream>
#include <algorithm>
using namespace std;
int item[111111];
int n, bin;
int main(void) {
    cin >> n;
    cin >> bin;
    for (int i = 0; i < n; i++) cin >> item[i];
    sort(item, item + n);
    int l = 0, r = n - 1, cnt = 0;
    while (l <= r) {
        if (item[l] + item[r] <= bin) l++;
        r--;
        ++cnt;
    }
    cout << cnt;
    return 0;
}
