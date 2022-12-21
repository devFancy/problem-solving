#include <stdio.h>

int main(int argc, const char * argv[]) {
   
    int year;
    int yun = 1;
    int yun2 = 0;
    scanf("%d",&year);

    if(year<1 || year >4000) printf("error\n");
  
    if((year % 4) == 0 && (year % 100) !=0 || (year % 400) == 0)
    {
        printf("%d\n",yun);
    }
    else
        printf("%d\n",yun2);
    
    return 0;
    
    
    
    return 0;
}
