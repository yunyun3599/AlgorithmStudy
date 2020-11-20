#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<algorithm>


using namespace std;

typedef struct meeting {
	int start;
	int end;
};

bool sorting(meeting& x, meeting& y) {
	if (x.end == y.end)
		return x.start < y.start;
	else
		return x.end < y.end;
}

int main() {
	int total;
	scanf("%d", &total);
	int result = 1;
	meeting info[100000];
	for (int i = 0; i < total; i++) {
		scanf("%d%d", &info[i].start, &info[i].end);
	}
	sort(info, info + total, sorting);

	int end = info[0].end;

	for (int i = 1; i < total; i++) {
		if (info[i].start >= end) {
			result++;
			end = info[i].end;
		}
	}

	printf("%d", result);
}