import sys

N,K  = map(int, input().split())

answer = 0

while(bin(N).count('1') > K) : #2진수 변환 후 1의 개수가 K보다 많을 때 반복

      loc = bin(N)[::-1].index('1')  #처음부터 끝까지 역순으로 확인

      answer += 2**loc

      N += 2**loc

        

print(answer)

