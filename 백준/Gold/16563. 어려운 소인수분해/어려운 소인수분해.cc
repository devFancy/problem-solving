#include <cstdio>
#include <iostream>
#include <algorithm>
#define MAX 5000003
using namespace std;
using ll = long long;
int check[MAX];
char buf[1 << 17];

char read() {
	static int idx = 1 << 17;
	if (idx == 1 << 17) {
		fread(buf, 1, 1 << 17, stdin);
		idx = 0;
	}
	return buf[idx++];
}
int readInt() {
	int sum = 0;
	bool flg = 1;
	char now = read();

	while (now == 10 || now == 32) now = read();
	if (now == '-') flg = 0, now = read();
	while (now >= 48 && now <= 57) {
		sum = sum * 10 + now - 48;
		now = read();
	}

	return flg ? sum : -sum;
}
int main() {
	ios::sync_with_stdio(NULL);
	check[0] = check[1] = 1;
	for (ll i = 2; i * i <= MAX; i++) if (!check[i])
		for (ll j = i * i; j <= MAX; j += i) if (!check[j]) check[j] = i;
			
	int N = readInt();
	int num;
	for (int i = 0; i < N; i++) {
		num = readInt();
		while (check[num]) {
			cout << check[num] << ' ';
			num /= check[num];
		}
		cout << num << "\n";
	}
	return 0;
}