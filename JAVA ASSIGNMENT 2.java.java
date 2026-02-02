// ASSIGNMENT 2 
// Q1

public class Main {
    private int rollNumber;
    private String name;
    private int semester;

    public Main(int rollNumber, String name, int semester) {
        setRollNumber(rollNumber);
        setName(name);
        setSemester(semester);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        if (rollNumber <= 0) {
            throw new IllegalArgumentException();
        }
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester < 0) {
            throw new IllegalArgumentException();
        }
        this.semester = semester;
    }

    public static void main(String[] args) {
        Main s = new Main(1, "Student", 3);
        System.out.println(s.getRollNumber());
        System.out.println(s.getName());
        System.out.println(s.getSemester());
    }
}

// Q2

abstract class Main {
    private int rollNumber;
    private String name;
    private int semester;

    public Main(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.semester = semester;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    abstract double calculateGrade();

    public void displayDetails() {
        System.out.println(rollNumber);
        System.out.println(name);
        System.out.println(semester);
        System.out.println(calculateGrade());
    }

    public static void main(String[] args) {
        Main s = new Undergraduate(1, "Student", 3, 85);
        s.displayDetails();
    }
}

class Undergraduate extends Main {
    private double marks;

    public Undergraduate(int rollNumber, String name, int semester, double marks) {
        super(rollNumber, name, semester);
        this.marks = marks;
    }

    double calculateGrade() {
        return marks / 10;
    }
}


// Q3

class Main {
    private int rollNumber;
    private String name;
    private int semester;
    private static String universityName;

    static {
        universityName = "ABC University";
    }

    public Main(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.semester = semester;
    }

    public static void displayUniversityName() {
        System.out.println(universityName);
    }

    public void displayStudent() {
        System.out.println(rollNumber);
        System.out.println(name);
        System.out.println(semester);
    }

    public static void main(String[] args) {
        Main s1 = new Main(1, "Student1", 3);
        Main s2 = new Main(2, "Student2", 4);

        s1.displayStudent();
        s2.displayStudent();

        Main.displayUniversityName();
    }
}


// Q4

class Main {
    private int rollNumber;
    private String name;
    private int semester;
    final int MAX_SEMESTER = 8;

    public Main(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        if (semester <= MAX_SEMESTER) {
            this.semester = semester;
        }
    }

    final void showRules() {
        System.out.println(MAX_SEMESTER);
    }

    public static void main(String[] args) {
        Main s = new Main(1, "Student", 3);
        s.showRules();
    }
}

class Child extends Main {
    public Child(int rollNumber, String name, int semester) {
        super(rollNumber, name, semester);
    }

    
}


//Q5


abstract class Main {
    private int rollNumber;
    private String name;
    private int semester;

    public Main(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.semester = semester;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    abstract double calculateGrade();

    public static void main(String[] args) {
        Main s1 = new EngineeringStudent(1, "EngStudent", 5, 80, 90);
        Main s2 = new MedicalStudent(2, "MedStudent", 4, 85, 75);

        System.out.println(s1.calculateGrade());
        System.out.println(s2.calculateGrade());
    }
}

class EngineeringStudent extends Main {
    private double internalAssessment;
    private double externalAssessment;

    public EngineeringStudent(int rollNumber, String name, int semester,
                              double internalAssessment, double externalAssessment) {
        super(rollNumber, name, semester);
        this.internalAssessment = internalAssessment;
        this.externalAssessment = externalAssessment;
    }

    double calculateGrade() {
        return (internalAssessment * 0.4) + (externalAssessment * 0.6);
    }
}

class MedicalStudent extends Main {
    private double theoryMarks;
    private double practicalMarks;

    public MedicalStudent(int rollNumber, String name, int semester,
                          double theoryMarks, double practicalMarks) {
        super(rollNumber, name, semester);
        this.theoryMarks = theoryMarks;
        this.practicalMarks = practicalMarks;
    }

    double calculateGrade() {
        return (theoryMarks + practicalMarks) / 2;
    }
}


// Q6

class Main implements SportsParticipant, CulturalParticipant {
    private int rollNumber;
    private String name;

    public Main(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public void playSport() {
        System.out.println("Plays sport");
    }

    public void performActivity() {
        System.out.println("Performs cultural activity");
    }

    public static void main(String[] args) {
        Main s = new Main(1, "Student");
        s.playSport();
        s.performActivity();
    }
}

interface SportsParticipant {
    void playSport();
}

interface CulturalParticipant {
    void performActivity();
}


// Q7

class Main {
    public static void main(String[] args) {
        AllRounderStudent s =
                new AllRounderStudent(1, "Student", 4, 80);
        s.playSport();
        s.performActivity();
        System.out.println(s.calculateGrade());
    }
}

abstract class Student {
    protected int rollNumber;
    protected String name;
    protected int semester;

    public Student(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.semester = semester;
    }

    abstract double calculateGrade();
}

interface SportsParticipant {
    void playSport();
}

interface CulturalParticipant {
    void performActivity();
}

class AllRounderStudent extends Student
        implements SportsParticipant, CulturalParticipant {

    private double marks;

    public AllRounderStudent(int rollNumber, String name,
                             int semester, double marks) {
        super(rollNumber, name, semester);
        this.marks = marks;
    }

    public double calculateGrade() {
        return marks / 10;
    }

    public void playSport() {
        System.out.println("Plays sport");
    }

    public void performActivity() {
        System.out.println("Performs cultural activity");
    }
}


// Q8

class Main {
    public static void main(String[] args) {
        Student s;

        s = new EngineeringStudent(80, 90);
        System.out.println(s.calculateGrade());

        s = new MedicalStudent(85, 75);
        System.out.println(s.calculateGrade());

        s = new AllRounderStudent(88);
        System.out.println(s.calculateGrade());
    }
}

abstract class Student {
    abstract double calculateGrade();
}

class EngineeringStudent extends Student {
    private double internal;
    private double external;

    public EngineeringStudent(double internal, double external) {
        this.internal = internal;
        this.external = external;
    }

    double calculateGrade() {
        return (internal * 0.4) + (external * 0.6);
    }
}

class MedicalStudent extends Student {
    private double theory;
    private double practical;

    public MedicalStudent(double theory, double practical) {
        this.theory = theory;
        this.practical = practical;
    }

    double calculateGrade() {
        return (theory + practical) / 2;
    }
}

class AllRounderStudent extends Student {
    private double marks;

    public AllRounderStudent(double marks) {
        this.marks = marks;
    }

    double calculateGrade() {
        return marks / 10;
    }
}


// Q9

class Main {
    public static void main(String[] args) {
        SportsParticipant s = new AllRounderStudent();
        s.playSport();
    }
}

interface SportsParticipant {
    void playSport();
}

class AllRounderStudent implements SportsParticipant {
    public void playSport() {
        System.out.println("Plays sport");
    }
}



