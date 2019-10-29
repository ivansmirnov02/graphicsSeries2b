package graphicsSeries2;
import java.util.Arrays;

public class Main {

    public static String[] group = {"LLLLLL", "LLGLGG", "LLGGLG", "LLGGGL", "LGLLGG",
            "LGGLLG", "LGGGLL", "LGLGLG", "LGLGGL", "LGGLGL"};
    public static String[] lcode = {"0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"};

    public static String[] gcode = {"0100111", "0110011", "0011011", "0100001", "0011101",
            "0111001", "0000101", "0010001", "0001001", "0010111"};

    public static String[] rcode = {"1110010", "1100110", "1101100", "1000010", "1011100",
            "1001110", "1010000", "1000100", "1001000", "1110100"};

    public static void main(String[] args) {
        String digit = "590123412345";
        System.out.println(encodeBarcode(digit));
    }

    public static String encodeBarcode(String digit) {
        String ris = "";
        int[] arr = split(digit);
        digit += checksum(arr);
        System.out.println(checksum(arr));
        String truedigit = digit.substring(1, digit.length());
        String str = group[Integer.parseInt(Character.toString(digit.charAt(0)))];
        System.out.println(str);
        String[] letter = str.split("");
        ris += "101";
        int c;
        for (int i = 0; i < letter.length; i++) {
            c = Integer.parseInt(Character.toString(truedigit.charAt(i)));
            if (letter[i].equals("L")) {
                ris += lcode[c];

            } else {
                ris += gcode[c];
            }
            System.out.println(ris);
        }
        ris += "01010";
        for (int i = 6; i < 12; i++) {
            c = Integer.parseInt(Character.toString(truedigit.charAt(i)));
            ris += rcode[c];
        }
        return ris + "101";
    }//end encodeBarcode

    public static int[] split(String digit) {
        String[] arr = digit.split("");
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        return num;
    }//end split

    public static int checksum(int[] arr) {
        int sum = 0;
        int nmt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i%2 == 0) {
                sum += arr[i] * 1;
            } else {
                sum += arr[i] * 3;
            }
        }
        nmt = sum;
        while (nmt % 10 != 0) {
            nmt++;
        }

        return nmt - sum;
    }//end checksum
}//end class