#include <stdio.h>
int main(int argc, const char * argv[]) {
    
    int arr[10] ={0,};
//    int rest;
    int count;
    int result=0;
//    int num;
    
    for(int i=0; i<10; i++)
    {
        scanf("%d", &arr[i]);
        arr[i] = arr[i] % 42;
    }
    
    for(int i=0; i<10; i++)
    {
        count =0;
        for(int j=i+1; j<10; j++)
        {
            if(arr[i] == arr[j])
                count++;
        }
        if(count == 0)
            result++;
    }
    printf("%d\n",result);

    return 0;
}