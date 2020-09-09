package miu;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        MinAddToMakeValid test = new MinAddToMakeValid();
        System.out.println(test.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        // maintain balance of string
        int tracker = 0;
        int ans = 0;

        for (int i = 0; i < S.length(); ++i) {

            tracker += S.charAt(i) == '(' ? 1 : -1;

            // It is guaranteed bal >= -1
            if (tracker == -1) {
                ans += 1;
                tracker += 1;
            }
        }

        return tracker + ans;
    }
}
