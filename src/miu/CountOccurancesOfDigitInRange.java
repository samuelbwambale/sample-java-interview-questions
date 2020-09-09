package miu;
// 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35
public class CountOccurancesOfDigitInRange {
    public static void main(String[] args) {
        System.out.println(getOccurances(3,35)); // 3,13,23,30,33
        System.out.println(getOccurances2(3,35));
    }

    public static int getOccurances(int digit, int range) {
        if(range == 0) return 0;
        if(digit > range) return 0;

        int count = 0;
        for(int i = 0; i <= range; i++) {
            if(i == digit) count++;
            else {
                String str = Integer.toString(i);
                count += countOccurancesInSingleNumber(digit, str);
            }
        }

        return count;
    }

    private static int countOccurancesInSingleNumber(int digit, String str) {
        if(str == "") return 0;

        String digitAsString = Integer.toString(digit);
        int index = str.indexOf(digitAsString);
        if(index != -1)
            return 1 + countOccurancesInSingleNumber(digit, str.substring(index + 1));
        return 0;
    }


    // Count occurances using while loop
    public static int getOccurances2(int digit, int range) {
        // Initialize result
        int count = 0;

        for (int i = 0; i <= range; i++)
            count += occurancesInNumber(digit, i);

        return count;
    }

    static int occurancesInNumber(int digit, int n)
    {
        int count = 0;
        while (n > 0)
        {
            if (n % 10 == digit)
                count++;

            n = n / 10;
        }
        return count;
    }


}
