-- Insert sample questions on application startup (only if they don't exist)

-- JAVA Questions
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What keyword is used to define a class in Java?', 'class', 'interface', 'extends', 'implements', 'class', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What keyword is used to define a class in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What keyword is used to define an interface in Java?', 'class', 'interface', 'extends', 'implements', 'interface', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What keyword is used to define an interface in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What keyword is used for inheritance in Java?', 'class', 'interface', 'extends', 'implements', 'extends', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What keyword is used for inheritance in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the default value of a boolean variable in Java?', 'true', 'false', '0', 'null', 'false', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the default value of a boolean variable in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which keyword is used for exception handling in Java?', 'try', 'throw', 'catch', 'All of the above', 'All of the above', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which keyword is used for exception handling in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What does the "final" keyword indicate in Java?', 'It indicates that a variable is constant.', 'It indicates that a method can be accessed without creating an instance of the class.', 'It indicates that a class cannot be extended.', 'Both A and C', 'Both A and C', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What does the "final" keyword indicate in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the correct way to declare a constant in Java?', 'constant int x = 5;', 'final int x = 5;', 'static int x = 5;', 'const int x = 5;', 'final int x = 5;', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the correct way to declare a constant in Java?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which loop is used when you know the number of iterations?', 'for loop', 'while loop', 'do-while loop', 'All of the above', 'for loop', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which loop is used when you know the number of iterations?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the purpose of the "break" statement?', 'To terminate a loop or switch statement and transfer control to the next statement.', 'To skip the rest of the code in a loop and move to the next iteration.', 'To define a label for a loop', 'To exit the program', 'To terminate a loop or switch statement and transfer control to the next statement.', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the purpose of the "break" statement?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the purpose of the "continue" statement?', 'To terminate a loop or switch statement and transfer control to the next statement.', 'To skip the rest of the code in a loop and move to the next iteration.', 'To define a label for a loop', 'To exit the program', 'To skip the rest of the code in a loop and move to the next iteration.', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the purpose of the "continue" statement?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which collection class does not allow duplicate elements?', 'HashMap', 'ArrayList', 'LinkedList', 'HashSet', 'HashSet', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which collection class does not allow duplicate elements?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which method is used to get the size of an ArrayList?', 'count()', 'size()', 'length()', 'getSize()', 'size()', 'Easy', 'JAVA'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which method is used to get the size of an ArrayList?');

-- Python Questions
INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the output of [1, 2, 3] + [4]?', '[1, 2, 3]', '[1, 2, 3, 4]', '[4, 3, 2, 1]', '[5, 6, 7]', '[1, 2, 3, 4]', 'Easy', 'Python'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the output of [1, 2, 3] + [4]?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the purpose of the "pass" statement in Python?', 'break', 'continue', 'pass', 'exit', 'pass', 'Easy', 'Python'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the purpose of the "pass" statement in Python?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'What is the purpose of the range() function?', 'To generate a random number within a given range.', 'To iterate over a sequence of numbers.', 'To sort a list in ascending order.', 'To find the maximum value in a list.', 'To iterate over a sequence of numbers.', 'Easy', 'Python'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'What is the purpose of the range() function?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which data type is used to store text in Python?', 'int', 'float', 'str', 'char', 'str', 'Easy', 'Python'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which data type is used to store text in Python?');

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficultylevel, category)
SELECT 'Which module is used for date and time operations in Python?', 'datetime', 'math', 'os', 'sys', 'datetime', 'Easy', 'Python'
WHERE NOT EXISTS (SELECT 1 FROM question WHERE question_title = 'Which module is used for date and time operations in Python?');
