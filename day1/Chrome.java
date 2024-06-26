package week1.day1;

public class Chrome {
    public static void main(String[] args) {
        // Declare and initialize a float variable to store the browser version
        float browserVersion = 91.0f;
        
        // Declare and initialize a String variable to store the developer's name
        String developer = "Google";
        
        // Declare and initialize a boolean variable to indicate if the browser is in beta
        boolean isBeta = false;
        
        // Declare and initialize an int variable to store the release year of the browser
        int releaseYear = 2008;
        
        // Declare and initialize a char variable to store the shortcut key for the browser
        char shortcutKey = 'C';

	/*
	 * Print the browser version, developer, if the browser is in beta, release year
	 * & shortcut key for the browser
	 */
	System.out.println("The browser version is " + browserVersion);
        System.out.println("The developer of the web browser is " + developer);
        System.out.println("Is the browser in Beta: " + isBeta);
        System.out.println("The browser was released in the year " + releaseYear);
        System.out.println("Shortcut key for the browser is " + shortcutKey);
    }
}
