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