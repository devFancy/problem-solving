#include <stdio.h>

int main(int argc, const char * argv[]) {
   
    int a,b;
    int flag= 0;
    scanf("%d %d",&a,&b);
    
    if((a < -10000) || (a >10000)) flag = 1;
    if((b < -10000) || (b > 10000)) flag = 1;
    
    if(flag ==1) printf("error\n");
    
    else{
        if(a > b) printf(">\n");
        else if(a < b) printf("<\n");
        else
            printf("==\n");
    }
    
           
    return 0;
}
