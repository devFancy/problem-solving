#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    int C;
    
    scanf("%d", &C);
    
    for(int i=0; i<C; i++)
    {
        int N;
        int sum=0;  //총점
        double avg;  //평균
        int count =0;   //평균을 넘을때 +1를 해준다.
        
        scanf("%d", &N);
        int arr[N];
        for(int j=0; j<N; j++)
        {
            scanf("%d",&arr[j]);
            sum+= arr[j];
        }
        avg = sum / N;
        //평균을 넘을때 +1를 해서 비율을 구한다.
        for(int k=0; k< N; k++)
        {
            if(arr[k] > avg)
            {
                count++;
            }
        }
        printf("%0.3lf%%\n", (double)count/N*100);
    }
   
    return 0;
}