
#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    //a,b,c 값, 곱한값, 몇번씩 쓰였는지 =>**중요 다시()
    int a,b,c;
    int arr[10] = {0, };          //(중요) 0으로 초기화
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);
    int total = a*b*c;
    int rest;
    
    while(total >0){
        rest = total %10;   //나머지
        arr[rest]++;
        total /= 10;
    }
    for(int i=0; i<10; i++)
    {
        printf("%d\n",arr[i]);
    }
    
    return 0;
}