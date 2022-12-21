
#include <stdio.h>
//3)한수  =>다시()()
int han(int );
int main(int argc, const char * argv[]) {
    //x의 자리수가 등차수열을 이룬다 => 210 => 1-2 = 0-1
    int input, count;
    scanf("%d",&input);
    count = han(input);
    printf("%d\n", count);
    
    return 0;
}
int han(int n)
{
    int i, cnt =0, hun, ten, one;
    if(n<100)
        return n;
    else{
        for(i=100; i<=n; i++)
        {
            hun = i/100;
            ten = (i%100) / 10;
            one = (i%100) % 10;
            if((hun - ten) == (ten - one))
                cnt++;
        }
        return (cnt+99);
    }
    
}