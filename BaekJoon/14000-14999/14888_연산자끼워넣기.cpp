#include <stdio.h>
#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;

int N;
int num[12] = { 0, };
int opt[4] = { 0, };		//µ¡¼À, »¬¼À, °ö¼À, ³ª´°¼À ¼ø¼­
int MAX = -1000000000;
int MIN = 1000000000;

void calc(int res, int idx) {
	if (idx == N) {
		MAX = max(MAX, res);
		MIN = min(MIN, res);
		return;
	}

	for (int i = 0; i < 4; i++) {
		switch (i) {
		case 0: 
			if (opt[i]--) calc(res + num[idx], idx+1);
			break;
		case 1: 
			if (opt[i]--) calc(res - num[idx], idx+1);
			break;
		case 2: 
			if (opt[i]--) calc(res * num[idx], idx+1);
			break;
		case 3: 
			if (opt[i]--) calc(res / num[idx], idx+1);
		}
		opt[i]++;
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) cin >> num[i];
	for (int i = 0; i < 4; i++) cin >> opt[i];
	calc(num[0], 1);
	printf("%d\n%d", MAX, MIN);
}

