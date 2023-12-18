public class Say {

    public String say(long number) {
        String[] oneNumber = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] twoNumber = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eightty", "ninety"};
        String[] decimal = {"thousand", "milion", "billion", ""};
        long minNumber = 0L;
        long maxNumber = 999999999999L;
        long step = 1000L;
        int length =  String.valueOf(number).length();
        String strNumber = "";
        while (number % step < step && step <= 1000000000000L) {
            String result = String.valueOf(number % step).substring(0, 3);
            strNumber = String.join(" ", result, strNumber);
            step *= 1000L;
        }
        String result = "";
        String[] listNumber = strNumber.split(" ");
        for (int i = listNumber.length - 1; i > 0; i--) {
            String hundredNumberString = "";
            int iNumber = Integer.valueOf(listNumber[i]);
            int dozens = iNumber % 100;
            int hundred = iNumber / 100;
            if (dozens >= 0 && dozens <= 20) {
                hundredNumberString = oneNumber[dozens];
            } else {
                int unit = dozens % 10;
                int dozen = dozens / 10;
                hundredNumberString = String.join("-", twoNumber[dozen], oneNumber[unit]);
            }
            if (hundred > 0) {
                hundredNumberString = String.join(" ", oneNumber[hundred], "hundred", hundredNumberString);
            }
            if (listNumber.length > 1) {
                result = String.join(" ", decimal[listNumber.length - 1 - i],hundredNumberString, result);
            } else {
                result = String.join(" ", hundredNumberString, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Say say = new Say();
        long number = 987_654_321_123L;
        System.out.println(say.say(100));
    }
}
