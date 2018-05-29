CREATE TABLE User (
  id long(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  role varchar(50) NOT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;