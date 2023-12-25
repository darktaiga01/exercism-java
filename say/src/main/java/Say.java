import java.util.Scanner;

public class Say {

    public String say(long number) {
        String[] oneNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] twoNumber = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] decimal = {"thousand", "million", "billion", ""};
        if (number >= 0 && number < 20) {
           return oneNumber[(int) number];
        } else if (number >= 20 && number < 100) {
            int unit = (int) (number % 10);
            int dozen = (int) (number / 10);
            return String.join("-", twoNumber[dozen], oneNumber[unit]);
        }
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
                if (dozen % 10 == 0) {
                    hundredNumberString = twoNumber[dozen];
                } else {
                    hundredNumberString = String.join("-", twoNumber[dozen], oneNumber[unit]);
                }
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

        boolean isRunning = true;
        Say say = new Say();
        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number: ");
            long number = scanner.nextLong();
            System.out.println(say.say(number));
        }
    }
}
