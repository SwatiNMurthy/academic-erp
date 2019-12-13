# Academic ERP

## PROJECT 3.3: Faculty Grade Students
Ask the faculty to login and then allow him to select a course among all the courses he teaches. Display all students enrolled in that course. Allow the faculty to grade a particular student or a group of students with marks.

## ROLL NUMBERS: 
SWATI N MURTHY MT2019120
SRAVYA M MT2019114

## Configuration File
Update configurations in the following files:

* #### Database details:
```
/academicerp/src/main/resources/hibernate.properties
```
* #### Other Configurations:
```
/academicerp/src/main/resources/config.properties
```

## Running the Application
* Download the Tomcat Server
* Add its configuration to your project
* Add the exploded war artifact to the deployment
* Set the Application Context

## Initialising the Database
We have the following tables in our DATABASE academicerp 
Faculty(id, name, username, password)
Student (rollNumber, name)
Course (courseId, courseName, faculty_facultyId)
CourseStudent (COURSE_ID, STUDENT_ID, grade)

### OnetoMany relationship
Faculty and Course are having a onetomany relationship, i.e., each course can be taught by one faculty.
So, We are using json OnetoMany mapping, to store facultyId in Course table

### ManytoMany relationship
Student and Course are having manytomany relationship.
We are creating a new table CourseStudent to store the details and grade of the student in this.

You may initialise the tables using the following or similar queries:
```
INSERT INTO Student (rollNumber, name) VALUES
(1, 'swati'),
(2, 'sravya'),
(3, 'meena'),
(4, 'shiv');

INSERT INTO Faculty (name, username, password) VALUES
('RBR', 'ravi', 'a1234'),
('Murli', 'murli', 'a1234'),
('Khaleel', 'khaleel', 'a1234'),
('Raghavan', 'raghavan', 'a1234'),
('Das', 'das', 'a1234'),
('Thangaraju', 'raju', 'a1234'),
('RC', 'rc', 'a1234');

INSERT INTO Course (courseId, courseName, faculty_facultyId) VALUES
(1, 'Algorithms', 1),
(2, 'Networks', 5),
(3, 'Gate', 2);

INSERT INTO CourseStudent (COURSE_ID, STUDENT_ID, grade) VALUES
(1, 1, 50),
(1, 2, 50),
(1, 3, 50),
(2, 1, 50),
(2, 2, 50);
```

## Welcome File
/academicerp/src/main/webapp/facultylogin.html

## Steps to run the project
* Run the project in intelliJ
* Enter any faculty login details as das, a1234 (or any other usernme/password combo of Faculty table) and click on Login, which displays the course id, name handled by that faculty
* Click on any course, which displays the students id, name, grade who enrolled for that course.
* update the grades of the students and click on Save.
