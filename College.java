import java.util.HashSet;

public class College {

    // Instance variables
    private String name;
    private double cost;
    private HashSet<String> requirements;
    private String location;
    private String majorApplyingFor;
    private String deadline;
    private boolean completedApplication;
    private String admissionDecision;

    // Constants
    final int DASH_ONE_INDEX = 2;
    final int DASH_TWO_INDEX = 5;

    // Default constructor
    public College() {
        name = null;
        cost = 0;
        requirements = new HashSet<>();
        majorApplyingFor = null;
        completedApplication = false;
        admissionDecision = "None";
        deadline = "No deadline";
    }

    // Second constructor for specified college
    public College(String name, double cost, String location, String majorApplyingFor,
            String deadline) {
        if (name == null || location == null || majorApplyingFor == null || deadline == null ||
                cost < 0 || !checkDeadline(deadline)) {
            throw new IllegalArgumentException("Parameter can't be null. Deadline must be valid "
                    + " and follow format XX/XX/XXXX. Cost must be non-negative.");
        }
        this.name = name;
        this.cost = cost;
        this.location = location;
        requirements = new HashSet<>();
        this.majorApplyingFor = majorApplyingFor;
        completedApplication = false;
        admissionDecision = "None";
        this.deadline = deadline;
    }

    // Check if the passed in date for deadline follows the correct format and is
    // valid
    private boolean checkDeadline(String deadline) {
        final int DATE_LENGTH = 10;
        final String POSSIBLE_CHARACTERS = "0123456789/";
        final String THIRTY_ONE_DAY_MONTHS = "135781012";
        final String THIRTY_DAY_MONTHS = "";
        final int NUM_MONTHS = 12;
        final int NUM_DAYS = 31;
        if (deadline.length() != DATE_LENGTH) {
            return false;
        }
        for (int i = 0; i < deadline.length(); i++) {
            String currChar = "" + deadline.charAt(i);
            if (!POSSIBLE_CHARACTERS.contains(currChar)) {
                return false;
            }
        }
        int month = Integer.parseInt(deadline.substring(0, DASH_ONE_INDEX));
        int day = Integer.parseInt(deadline.substring(DASH_ONE_INDEX + 1, DASH_TWO_INDEX));
        if (deadline.charAt(DASH_ONE_INDEX) != '/' || deadline.charAt(DASH_TWO_INDEX) != '/' ||
                month < 0 || month > NUM_MONTHS || day < 0 || day > NUM_DAYS) {
            return false;
        }
        return true;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid Parameter. Parameter can't be null.");
        }
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            return "No name";
        }
        return name;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Invalid Parameter. Cost must be non-negative.");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void addRequirements(HashSet<String> requirementsToAdd) {
        if (requirementsToAdd == null) {
            throw new IllegalArgumentException("Invalid Parameter. Parameter can't be null.");
        }
        requirements.addAll(requirementsToAdd);
    }

    public HashSet<String> getRequirements() {
        return requirements;
    }

    public void printRequirements(HashSet<String> requirements) {
        if (requirements.size() == 0) {
            System.out.println("No requirements");
        } else {
            for (String currRequirement : requirements) {
                System.out.println("- " + currRequirement);
            }
        }
    }

    public void setLocation(String location) {
        if (location == null) {
            throw new IllegalArgumentException("Invalid Parameter. Parameter can't be null.");
        }
        this.location = location;
    }

    public String getLocation() {
        if (location == null) {
            return "No Location Recorded";
        }
        return location;
    }

    public void setMajorApplyingFor(String major) {
        if (major == null) {
            throw new IllegalArgumentException("Invalid Parameter. Parameter can't be null.");
        }
        majorApplyingFor = major;
    }

    public String getMajor() {
        if (majorApplyingFor == null) {
            return "No Major Recorded";
        }
        return majorApplyingFor;
    }

    public void setDeadline(String deadline) {
        if (deadline == null || !checkDeadline(deadline)) {
            throw new IllegalArgumentException("Invalid Parameter. Parameter can't be null."
                    + " Date must be valid and follow format: XX/XX/XXXX");
        }
        this.deadline = deadline;
    }

    public String getDeadline() {
        if (deadline == null) {
            return "No Deadline Recorded";
        }
        return deadline;
    }

    public void updateCompletionStatus(boolean status) {
        completedApplication = status;
    }

    public boolean getCompletionStatus() {
        return completedApplication;
    }

    public void updateAdmissionDecision(String status) {
        admissionDecision = status;
    }

    public String getAdmissionDecision() {
        return admissionDecision;
    }

    public void costAnalysis(College objectTwo) {
        System.out.println("Cost Difference: $" + Math.abs(this.cost - objectTwo.cost));
        if (this.cost > objectTwo.cost) {
            System.out.println(this.name + " is more expensive than " + objectTwo.name);
        } else if (this.cost < objectTwo.cost) {
            System.out.println(this.name + " is less expensive than " + objectTwo.name);
        } else {
            System.out.println(this.name + " is the same as " + objectTwo.name);
        }
    }

    public void printSummary() {
        System.out.println("College: " + name);
        System.out.println("Location: " + location);
        System.out.println("Deadline: " + deadline);
        System.out.println("Cost: $" + cost);
        System.out.println("Major Applying For: " + majorApplyingFor);
        System.out.print("Requirements: ");
        if (requirements.size() == 0) {
            System.out.println("No Requirements");
        } else {
            String[] requirementsInArray = requirements.toArray(new String[requirements.size()]);
            for (int i = 0; i < requirementsInArray.length - 1; i++) {
                System.out.print(" " + requirementsInArray[i] + ",");
            }
            System.out.println(" " + requirementsInArray[requirementsInArray.length - 1]);
        }

        String completed = completedApplication ? "Yes" : "No";
        System.out.println("Completed Application: " + completed);
        System.out.println("Admission Decision: " + admissionDecision);
    }

}
