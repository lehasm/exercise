
public class CommonPart {

    private static class Indexes {

        private final int first;
        private final int second;

        private Indexes(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Indexes{");
            sb.append("first=").append(first);
            sb.append(", second=").append(second);
            sb.append('}');
            return sb.toString();
        }
    }


    public static Indexes find(String[] first, String[] second) {
        Indexes index = new Indexes(-1, -1);

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                int dex = find(first, i, second, j);
                if (dex > -1) {
                    return new Indexes(i, j);
                }
            }
        }

        return index;
    }

    public static int find(String[] first, int indexFirst, String[] second, int indexSecond) {
        int i = 0;
        while (i + indexFirst < first.length && i + indexSecond < second.length) {
            if (!second[i + indexSecond].equals(first[i + indexFirst])) {
                return i > 1 ? i - 1 : -1;
            }

            i++;
        }

        return i;
    }


    public static void main(String[] args) {
        String[] first = {"a", "b", "c", "x", "y", "z"};
        String[] second = {"d", "e", "a", "d", "b", "e", "e", "f", "x", "y", "z", "g"};

        System.out.println(find(first, second));
    }

}
