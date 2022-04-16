import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculater {
    Calculater() {
        romanDigits = new HashMap<>();

        romanDigits.put("I", 1);
        romanDigits.put("II", 2);
        romanDigits.put("III", 3);
        romanDigits.put("IV", 4);
        romanDigits.put("V", 5);
        romanDigits.put("VI", 6);
        romanDigits.put("VII", 7);
        romanDigits.put("VIII", 8);
        romanDigits.put("IX", 9);
        romanDigits.put("X", 10);
        romanDigits.put("XI", 11);
        romanDigits.put("XII", 12);
        romanDigits.put("XIII", 13);
        romanDigits.put("XIV", 14);
        romanDigits.put("XV", 15);
        romanDigits.put("XVI", 16);
        romanDigits.put("XVII", 17);
        romanDigits.put("XVIII", 18);
        romanDigits.put("XIX", 19);
        romanDigits.put("XX", 20);
        romanDigits.put("XXI", 21);
        romanDigits.put("XXII", 22);
        romanDigits.put("XXIII", 23);
        romanDigits.put("XXIV", 24);
        romanDigits.put("XXV", 25);
        romanDigits.put("XXVI", 26);
        romanDigits.put("XXVII", 27);
        romanDigits.put("XXVIII", 28);
        romanDigits.put("XXIX", 29);
        romanDigits.put("XXX", 30);
        romanDigits.put("XXXI", 31);
        romanDigits.put("XXXII", 32);
        romanDigits.put("XXXIII", 33);
        romanDigits.put("XXXIV", 34);
        romanDigits.put("XXXV", 35);
        romanDigits.put("XXXVI", 36);
        romanDigits.put("XXXVII", 37);
        romanDigits.put("XXXVIII", 38);
        romanDigits.put("XXXIX", 39);
        romanDigits.put("XL", 40);
        romanDigits.put("XLI", 41);
        romanDigits.put("XLII", 42);
        romanDigits.put("XLIII", 43);
        romanDigits.put("XLIV", 44);
        romanDigits.put("XLV", 45);
        romanDigits.put("XLVI", 46);
        romanDigits.put("XLVII", 47);
        romanDigits.put("XLVIII", 48);
        romanDigits.put("XLIX", 49);
        romanDigits.put("L", 50);
        romanDigits.put("LI", 51);
        romanDigits.put("LII", 52);
        romanDigits.put("LIII", 53);
        romanDigits.put("LIV", 54);
        romanDigits.put("LV", 55);
        romanDigits.put("LVI", 56);
        romanDigits.put("LVII", 57);
        romanDigits.put("LVIII", 58);
        romanDigits.put("LIX", 59);
        romanDigits.put("LX", 60);
        romanDigits.put("LXI", 61);
        romanDigits.put("LXII", 62);
        romanDigits.put("LXIII", 63);
        romanDigits.put("LXIV", 64);
        romanDigits.put("LXV", 65);
        romanDigits.put("LXVI", 66);
        romanDigits.put("LXVII", 67);
        romanDigits.put("LXVIII", 68);
        romanDigits.put("LXIX", 69);
        romanDigits.put("LXX", 70);
        romanDigits.put("LXXI", 71);
        romanDigits.put("LXXII", 72);
        romanDigits.put("LXXIII", 73);
        romanDigits.put("LXXIV", 74);
        romanDigits.put("LXXV", 75);
        romanDigits.put("LXXVI", 76);
        romanDigits.put("LXXVII", 77);
        romanDigits.put("LXXVIII", 78);
        romanDigits.put("LXXIX", 79);
        romanDigits.put("LXXX", 80);
        romanDigits.put("LXXXI", 81);
        romanDigits.put("LXXXII", 82);
        romanDigits.put("LXXXIII", 83);
        romanDigits.put("LXXXIV", 84);
        romanDigits.put("LXXXV", 85);
        romanDigits.put("LXXXVI", 86);
        romanDigits.put("LXXXVII", 87);
        romanDigits.put("LXXXVIII", 88);
        romanDigits.put("LXXXIX", 89);
        romanDigits.put("XC", 90);
        romanDigits.put("XCI", 91);
        romanDigits.put("XCII", 92);
        romanDigits.put("XCIII", 93);
        romanDigits.put("XCIV", 94);
        romanDigits.put("XCV", 95);
        romanDigits.put("XCVI", 96);
        romanDigits.put("XCVII", 97);
        romanDigits.put("XCVIII", 98);
        romanDigits.put("XCIX", 99);
        romanDigits.put("C", 100);

        arabicToRoman = new HashMap();
        for (String key: romanDigits.keySet()) {
            arabicToRoman.put(romanDigits.get(key), key);
        }
    }

    public String calculate(final String in) throws IOException {
        Scanner scanner = new Scanner(in);

        int operandCount = 0;
        String firstOp = "";
        String operator = "";
        String secondOp = "";

        scanner.useDelimiter("\\s");
        while (scanner.hasNext()) {
            operandCount++;

            switch (operandCount) {
                case 1: firstOp = scanner.next();
                    break;

                case 2: operator = scanner.next();
                    break;

                case 3: secondOp = scanner.next();
                    break;

                default: scanner.next();
                    break;
            }

            // 1. Проверка кол-ва операндов
            if (operandCount > 3)
                throw new IOException("Неверное количество операндов");
        }
        scanner.close();

        // 2. Проверка оператора
        if (!(operator.equals("+")  || operator.equals("-") || operator.equals("/") || operator.equals("*")))
            throw new IOException("Недопустимый оператор: '" + operator + "'");

        try{
            // Обработка арабских чисел:
            final int firstNumber = Integer.parseInt(firstOp);
            final int secondNumber = Integer.parseInt(secondOp);

            // 3. Проверка диапазона арабских чисел:
            if (firstNumber < 1 || firstNumber > 10)
                throw new IOException("Недопустимый диапазон операнда: '" + firstOp + "'");

            if (secondNumber < 1 || secondNumber > 10)
                throw new IOException("Недопустимый диапазон операнда: '" + secondOp + "'");

            if (operator.equals("+"))
                return String.valueOf(firstNumber + secondNumber);
            if (operator.equals("-"))
                return String.valueOf(firstNumber - secondNumber);
            if (operator.equals("*"))
                return String.valueOf(firstNumber * secondNumber);
            if (operator.equals("/"))
                return String.valueOf(firstNumber / secondNumber);
        }
        catch (NumberFormatException ex){
            // Обработка римских чисел:
            final int firstNumber = convertRomanDigitToInt(firstOp);
            final int secondNumber = convertRomanDigitToInt(secondOp);

            // 4. Проверка диапазона римских чисел:
            if (firstNumber < 1 || firstNumber > 10)
                throw new IOException("Недопустимый диапазон операнда: '" + firstOp + "'");

            if (secondNumber < 1 || secondNumber > 10)
                throw new IOException("Недопустимый диапазон операнда: '" + secondOp + "'");

            if (operator.equals("+"))
                return convertIntToRoman(firstNumber + secondNumber);
            if (operator.equals("-"))
                return convertIntToRoman(firstNumber - secondNumber);
            if (operator.equals("*"))
                return convertIntToRoman(firstNumber * secondNumber);
            if (operator.equals("/"))
                return convertIntToRoman(firstNumber / secondNumber);
        }

//        System.out.println("first: " + firstOp);
//        System.out.println("operator: " + operator);
//        System.out.println("second: " + secondOp);

        return "ERROR";
    }

    Integer convertRomanDigitToInt(final String romanDigit) throws IOException {
        if (!romanDigits.containsKey(romanDigit))
            throw new IOException("Недопустимое римское число: '" + romanDigit + "'");

        return romanDigits.get(romanDigit);
    }

    String convertIntToRoman(final int digit) throws IOException {
        if (!arabicToRoman.containsKey(digit))
            throw new IOException("Нет соответствия римскому числу: '" + digit + "'");

        return arabicToRoman.get(digit);
    }

    private Map<String, Integer> romanDigits;
    private Map<Integer, String> arabicToRoman;
}
