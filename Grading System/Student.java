class Student {
    private String studentName, studentID, grade;
    private double assignmentOneMarks, assignmentTwoMarks, projectMark, individualTotalMarks;
    static final double P = 50.00;
    static final double HD = 85.00;

    public Student(String studentName, String studentID, String grade, double assignmentOneMarks,
            double assignmentTwoMarks, double projectMark, double individualTotalMark) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.grade = grade;
        this.assignmentOneMarks = assignmentOneMarks;
        this.assignmentTwoMarks = assignmentTwoMarks;
        this.projectMark = projectMark;
    }

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getAssignmentOneMarks() {
        return assignmentOneMarks;
    }

    public void setAssignmentOneMarks(double assignmentOneMarks) {
        this.assignmentOneMarks = assignmentOneMarks;
    }

    public double getAssignmentTwoMarks() {
        return assignmentTwoMarks;
    }

    public void setAssignmentTwoMarks(double assignmentTwoMarks) {
        this.assignmentTwoMarks = assignmentTwoMarks;
    }

    public double getProjectMark() {
        return projectMark;
    }

    public void setProjectMark(double projectMark) {
        this.projectMark = projectMark;
    }

    public double calculateIndividualTotalMarks() {
        this.individualTotalMarks = this.assignmentOneMarks + this.assignmentTwoMarks + this.projectMark;
        return this.individualTotalMarks;
    }

    public String calculateGrade() {
        this.calculateIndividualTotalMarks();
        if (this.individualTotalMarks >= Student.HD) {
            this.grade = "HD";
        } else if (this.individualTotalMarks >= 75) {
            this.grade = "D";
        } else if (this.individualTotalMarks >= 65) {
            this.grade = "C";
        } else if (this.individualTotalMarks >= Student.P) {
            this.grade = "P";
        } else {
            this.grade = "F";
        }
        return this.grade;
    }

}