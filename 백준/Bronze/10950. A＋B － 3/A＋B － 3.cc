
#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    int n,m;
    int t;
    scanf("%d",&t);
    
    for(int i=1;i<=t;i++)
    {
        scanf("%d %d",&n, &m);
        printf("%d\n", n+m);
    }
    
//    for(int i=1;i<=t;i++)
//    {
//        printf("%d\n", n+m);
//    }
    
    
    return 0;
}
