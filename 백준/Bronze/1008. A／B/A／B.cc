#include<stdio.h>
#include<stdlib.h>

int main() {
    
    int A,B;
    int flag1 =0, flag2 =0;
    scanf("%d", &A);
    if(A <= 0 ) flag1 = 1;
    scanf("%d", &B);
    if(B >= 10) flag2 = 1;
    if(flag1 ==1 || flag2 ==1)
    {
        printf("범위를 다시 확인해 주세요");
    }
    else
        printf("%.9f\n", (double)A/(double)B);
    
    return 0;
}
