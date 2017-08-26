// too simple

class Solution {
    public boolean judgeCircle(String moves) {

        int up = 0, left = 0, right = 0, down = 0;
        for (int i = 0; i < moves.length(); i++)
        {
            switch (moves.charAt(i))
            {
                case 'U': up++; break;
                case 'D': down++; break;
                case 'L': left++; break;
                case 'R': right++; break;
            }
        }

        return up == down && left == right;
    }
}
