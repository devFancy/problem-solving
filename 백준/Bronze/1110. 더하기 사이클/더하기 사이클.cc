#include <stdio.h>

int main(int argc, const char * argv[]) {
    //***중요***다시()
    int number;   //정수
    int a,b,c,d;//a은 몫 (10의자리), b은 나머지 (1의자리)
    int result;
    int count = 0;
    
    scanf("%d",&number);
    result = number;    //result는 처음의 값
//    if(number <0 || number >99) printf("다시 입력해주세요\n");
//    if(number <10) number = number*10;
    
  
    while(1)
    {
        a = number/10; b= number%10;
        c = (a+b)%10;          //c는 다음의 오른쪽 자리
        d = (b*10)+c;         //d는 새로운 두자리 수
        number = d;
        count++;
        if(d == result) break;
    }
    
    printf("%d",count);
    return 0;
}