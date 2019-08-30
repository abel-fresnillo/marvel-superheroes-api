DROP TABLE IF EXISTS hero;

CREATE TABLE hero (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(500) DEFAULT NULL,
  image_url VARCHAR(500) DEFAULT NULL
);