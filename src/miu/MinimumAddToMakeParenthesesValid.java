package miu;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
//      Input: "()))(("
//      Output: 4
        System.out.println(minAddToMakeValid("()))(("));

//          Input: "()"
//          Output: 0
//        System.out.println(minAddToMakeValid("()"));

//          Input: "((("
//          Output: 3
//        System.out.println(minAddToMakeValid("((("));

    }

    public static int minAddToMakeValid(String S) {
        // maintain balance of string
        int bal = 0;
        int ans = 0;

        for (int i = 0; i < S.length(); ++i) {

            bal += S.charAt(i) == '(' ? 1 : -1;

            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans += 1;
                bal += 1;
            }
        }

        return bal + ans;
    }
}
