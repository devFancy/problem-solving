#include<stdio.h>
#include<stdlib.h>

int main() {
    
    int r;
    int n;
    int n1,n2,n3;
   
    
    scanf("%d",&r);
    scanf("%d",&n);
    n1 = n%10;
    n2 = (n%100)/10;
    n3 = n/100;
    
    
    printf("%d\n",r*n1);
    printf("%d\n",r*n2);
    printf("%d\n",r*n3);
    printf("%d\n",r*n);
    
    return 0;
}