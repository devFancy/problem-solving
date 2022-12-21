#include <stdio.h>
  
int main(int argc, const char * argv[]) {
    
    int num;
    
    double avg =0, max = 0.0;
    
    scanf("%d", &num);
    double arr[1000];
    for(int i=0; i<num; i++)
    {
        scanf("%lf",&arr[i]);
        
        if(arr[i] >max)
            max = arr[i];
    }
    
    for(int i=0; i<num; i++)
    {
        arr[i] = arr[i] / max * 100.0;
        avg += arr[i];
    }
    printf("%0.2lf\n", avg/(double)num);       //num이 int형이므로 float형으로 해줘야한다.
    
    
    return 0;
}
