--In using database AUTO_INCREMENT id approach, you can still
--insert to the table with the ID you want. MySQL will take the
--value you provided, as long as you don't violate the keys.

INSERT INTO DEPARTMENT (DEPT_ID, DEPT_NAME) VALUES (5, 'IT');
INSERT INTO DEPARTMENT (DEPT_ID, DEPT_NAME) VALUES (6, 'HR');
INSERT INTO DEPARTMENT ( DEPT_NAME) VALUES ('Sales');
INSERT INTO DEPARTMENT ( DEPT_NAME) VALUES ('Marketing');
