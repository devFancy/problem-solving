#include <stdio.h>
#include <string.h>     //strlen 함수를 사용하기 위해서 헤더파일 추가
int main(int argc, const char * argv[]) {
    
    int num;
    int add;                //추가적으로 더해지는 점수
    int sum;                //최종점수
    char arr[81];           //0~80
    
    scanf("%d", &num);
    
    for(int i=0; i<num; i++)
    {
        sum = 0, add= 1;
        scanf("%s", arr);
        for(int j=0; j<strlen(arr); j++)
        {
            if(arr[j] == 'O')
            {
                sum+= add;
                add++;
            }
            else
                add=1;
        }
        printf("%d\n",sum);
    }
    
    return 0;
    //문자열을 직접 입력받으려면 -> scanf("%s", 배열명) 이용할 것!!
}