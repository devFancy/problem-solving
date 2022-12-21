
#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    int n;
    int i,j;
    
    scanf("%d",&n);
    for(i=1; i<=n; i++)
    {
        for(j=1; j<= (n-i); j++){
            printf(" ");}
        for(j=1; j<=i; j++){
            printf("*");}
        
        printf("\n");
    }
   
    
    return 0;
}