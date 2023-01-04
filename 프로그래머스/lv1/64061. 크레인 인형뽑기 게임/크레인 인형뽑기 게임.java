import java.util.Stack;

class Solution
{
    private final Stack<Integer> bag = new Stack<>();
    
    public int solution(int[][] board, int[] moves)
    {
        int answer = 0;
        
        for (int move : moves)
        {
            int j = move - 1;
            
            for (int i = 0; i < board.length; i++)
            {
                // 인형을 뽑을 경우
                if (board[i][j] > 0)
                {
                    // 뽑은 인형이 있고, 마지막 인형과 방금 뽑은 인형이 동일할 경우
                    if (!bag.isEmpty() && bag.peek() == board[i][j])
                    {
                        bag.pop();
                        
                        answer += 2;
                    }
                    
                    // 아닐 경우
                    else
                    {
                        bag.push(board[i][j]);
                    }
                    
                    board[i][j] = 0;
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}
