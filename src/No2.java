import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        /*
         * int[] Minibus = [4];
         * output minimum of busses need to rent
         * where all members of family should ride in the same busses
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of families: ");
        int numberOfFamilies = sc.nextInt();
        sc.nextLine();

        System.out.println("Input the number of members in the family (separated by a space): ");
        String[] members = sc.nextLine().split(" ");

        if (numberOfFamilies != members.length) {
            System.out.println("Input must be equal to the number of families");
            return;
        }

        int buses = 0;
        int currentLoad = 0;
        int maxLoadBus = 4;

        for (String member : members) {
            int familySize = Integer.parseInt(member);

            if (familySize > maxLoadBus) {
                buses += (familySize + 3) / maxLoadBus;
            } else {
                if (currentLoad + familySize > maxLoadBus) {
                    buses++;
                    currentLoad = familySize;
                } else {
                    currentLoad += familySize;
                }
            }
        }

        if (currentLoad > 0) {
            buses++;
        }
        System.out.println("Minimum bus required is: " + buses);
    }
}
