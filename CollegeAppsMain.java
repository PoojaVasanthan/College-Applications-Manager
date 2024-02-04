import java.util.HashSet;
import java.util.ArrayList;

public class CollegeAppsMain {

    public static void main(String[] args) {
        tests();
    }

    // Perform tests
    public static void tests() {
        College firstSchool = new College("The University of Texas at Austin",
                26580, "Austin, Texas", "Computer Science", "12/15/2024");
        HashSet<String> firstRequirements = new HashSet<>();
        firstRequirements.add("High School Transcript");
        firstRequirements.add("SAT/ACT Test Scores");
        firstRequirements.add("2 Letters of Recommendation");
        firstSchool.addRequirements(firstRequirements);
        firstSchool.printSummary();
        System.out.println();
        System.out.println();
        College secondSchool = new College("Georgia Tech",
                50000, "Atlanta, Georgia", "Computer Science", "11/30/2024");
        secondSchool.printSummary();
        System.out.println();
        System.out.println();
        College thirdSchool = new College("MIT",
                75900, "Cambridge, Massachusetts", "Computer Science", "11/30/2024");
        HashSet<String> thirdRequirements = new HashSet<>();
        thirdRequirements.add("High School Transcript");
        thirdSchool.addRequirements(thirdRequirements);
        thirdSchool.updateCompletionStatus(true);
        thirdSchool.printSummary();
        System.out.println();
        System.out.println();
        firstSchool.costAnalysis(thirdSchool);
        System.out.println();
        System.out.println();
        thirdSchool.costAnalysis(secondSchool);
    }

}
