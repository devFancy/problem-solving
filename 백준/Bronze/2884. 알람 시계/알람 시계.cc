#include <stdio.h>

int main() {

    int h, m;
    scanf("%d %d",&h, &m);
    
    if(h<0 || h>23) printf("다시 입력해주세요\n");
    if(m<0 || m>59) printf("다시 입력해주세요\n");
    
    if(m<45){
        if(h==0){
            h = 23;
        }
        else
            h -= 1;
        m += 15;
    }
    else
        m -= 45;
    
    printf("%d %d\n", h,m);
    
    return 0;
    
}