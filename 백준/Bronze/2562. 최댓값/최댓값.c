
#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
  
   
    int arr[9];
    int max=0;
    int index=0;
    
    for(int i=0;i<9;i++)
    {
        scanf("%d", &arr[i]);
            if(arr[i] > max)
                {
                    max = arr[i];
                    index = i;
                }
    }
    printf("%d\n%d\n",max,index+1);
   
    return 0;
}