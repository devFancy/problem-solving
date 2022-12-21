#include <stdio.h>

int main(int argc, const char * argv[]) {
   
    int score;
    int flag= 0;
    
    scanf("%d", &score);
    
    if(score <0 || score >100) flag = 1;
    if(flag ==1) printf("error\n");
    
    else
    {
        switch (score/10) {
            case 10: printf("A\n");
                break;
            case 9: printf("A\n");
                break;
            case 8: printf("B\n");
                break;
            case 7: printf("C\n");
                break;
            case 6: printf("D\n");
                break;
            default: printf("F\n");
                break;
        }
    }
           
    return 0;
}