#include <stdio.h>


int main(int argc, const char * argv[]) {
    // insert code here...

    int number;
    int min = 1000001, max = -1000001; //초기값 설정 중요하다.
    int num;
    scanf("%d",&number);


    for(int i=0; i<number; i++)
    {
        scanf("%d",&num);
        if(num > max)
            max = num;
        if(num < min)
            min = num;

    }
    printf("%d %d\n",min, max);

    return 0;
}