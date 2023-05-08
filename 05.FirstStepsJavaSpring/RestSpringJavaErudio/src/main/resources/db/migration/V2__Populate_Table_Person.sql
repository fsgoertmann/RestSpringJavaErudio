LOCK TABLES `person` WRITE;

INSERT INTO `person` (`id`, `address`, `birthdate`, `email`, `first_name`, `gender`, `last_name`) VALUES (1,'Blumenau','1989-08-27 00:00:00.000000','teste@teste.com','Felipe','Male','Goertmann'),(2,'Blumenau','1991-12-09 00:00:00.000000','heribeiro@teste.com','Helena','Female','Ribeiro'),(6,'Blumenau','2021-07-14 00:00:00.000000','test@teste.com','Thiago','Male','Goertmann'),(9,'Blumenau','1967-10-11 00:00:00.000000','test@shirley.com','Charles','Female','Goertmann'),(10,'Blumenau','1968-05-15 00:00:00.000000','test@shirley.com','Shirley','Female','Goertmann');

UNLOCK TABLES;
