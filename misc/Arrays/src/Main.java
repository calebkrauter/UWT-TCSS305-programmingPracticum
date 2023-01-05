public class Main {
    public static void main(String[] args) {


        makeArrays();
    }

    public static void makeArrays() {

        String array1[] = new String[100];


        for (int row = 1; row < 10; row++) {
            System.out.println();

            for (int col = 1; col < 10; col++) {

                if (col > 0 && col % 2 == 0) {
                    array1[col] = " COLUMN : ";
                    System.out.print(array1[col] + col + "|");
                } else if (row > 0 && row % 1 == 0){
                    array1[row] = " ROW : ";
                    System.out.print(array1[col] + row + "|");
                }
            }
        }
    }
}