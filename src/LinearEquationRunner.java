import java.util.Scanner;
public class LinearEquationRunner {
    public static void main (String[]args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1: ");
        String coor1 = scan.nextLine();
        String x1AsString = coor1.substring(1,coor1.indexOf(","));
        String y1AsString = coor1.substring(coor1.indexOf(" ") + 1,coor1.length() - 1);
        int x1 = Integer.parseInt(x1AsString);
        int y1 = Integer.parseInt(y1AsString);

        System.out.println("Enter coordinate 2: ");
        String coor2 = scan.nextLine();
        String x2AsString = coor2.substring(1,coor2.indexOf(","));
        String y2AsString = coor2.substring(coor2.indexOf(" ") + 1,coor2.length() - 1);
        int x2 = Integer.parseInt(x2AsString);
        int y2 = Integer.parseInt(y2AsString);


        if (x1 == x2) {
            System.out.println("These points are on a vertical line. x = " + x1);
            System.exit(0);
        }

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println(equation.lineInfo());

        System.out.println("Enter a value for x: ");
        double x3 = scan.nextDouble();
        scan.nextLine();
        System.out.println("The point on the line is " + equation.coordinateForX(x3));

    }
}