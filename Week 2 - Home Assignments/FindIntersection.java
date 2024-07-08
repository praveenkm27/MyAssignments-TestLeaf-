package week2.homeassignments;

public class FindIntersection {

    public static void main(String[] args) {
        // Declare and initialize two integer arrays
        int a[] = {3, 2, 11, 4, 6, 7};
        int b[] = {1, 2, 8, 4, 9, 7};

        // Iterate through each element of array a
        for (int i = 0; i < a.length; i++) {
            // Iterate through each element of array b
            for (int j = 0; j < b.length; j++) {
                // Check if the current element of array a is equal to the current element of array b
                if (a[i] == b[j]) {
                    // If they are equal, print the matching element
                    System.out.print(a[i] + " ");
                }
            }
        }
        // Print a message indicating that the printed elements are the matching items in both arrays
        System.out.print("are the matching items in both arrays.");
    }
}
