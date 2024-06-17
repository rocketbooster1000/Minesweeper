package root.consoleDisplays;

import java.util.InputMismatchException;
import java.util.Scanner;

import root.common.InOut;

public class ConsoleInOut implements InOut{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public MoveType move() {
        System.out.println("Flag or Break (f/b):");
        String str = scanner.nextLine();
        if (str.equals("f")){
            return MoveType.FLAG;
        } else if (str.equals("b")){
            return MoveType.BREAK;
        } else {
            System.out.println("invalid option");
            return move();
        }
    }

    @Override
    public int[] moveLocation() {
        return new int[]{
            getInt("row:"),
            getInt("col:")
        };
    }

    @Override
    public boolean wantRestart() {
        System.out.println("Enter y for new game or any other key to quit");
        return scanner.nextLine().equals("y");
    }

    public int getInt(String prompt){
        System.out.println(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid option");
            return getInt(prompt);
        }
    }
}
