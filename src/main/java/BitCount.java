public class BitCount {

    public static int count(int number){
        int count = 0;

        if(number < 0){
            count++;
            number *= -1;
        }

        while (number > 0){
            number = number & (number - 1);
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
