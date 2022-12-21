#include<cstdio>

const int N = 1e6+5;

bool np[N>>1] = {1,0,};

const int SIZ = 1 << 20;
char buf[SIZ];
char * p = buf;
inline void write(register char c) {
	if (p == buf + SIZ) {
		fwrite(buf, 1, SIZ, stdout);
		p = buf;
	}
	*p++ = c;
}
inline void writeint(register int i) {
	register char tmp[8], t = 0;
	while (i) {
		tmp[t++] = i % 10 + 48;
		i /= 10;
	}
	while (t) {
		write(tmp[--t]);
	}
}
auto sieve(int max_n) {
	int i, j, k;
	for(i=3; i*i<=max_n; i+=2) {
		if (np[i>>1]) continue;
		for(j=i*i, k=i+i; j<=max_n; j+=k)
			np[j>>1] = 1;
	}
}
int main() {
	int m, n;
	scanf("%d%d", &m, &n);
	sieve(n);
	if (m <= 2) writeint(2), write('\n');
	for(int i =m>>1; i<=n-1>>1; i++) if (!np[i]) writeint((i<<1)+1), write('\n');
	fwrite(buf, 1, p-buf, stdout);
}