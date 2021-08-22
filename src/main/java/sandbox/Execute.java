package sandbox;

public class Execute {
    public static void printName(int n) {
        if (n > 0) {
            System.out.println("Rifat Halim");
            printName(n-1);
        } else {
            System.out.println("Finished printing out the name");
        }
    }

    public static void main(String[] args) {
        printName(10);
    }
}
