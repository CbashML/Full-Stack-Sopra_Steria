DROP TABLE IF EXISTS outbound_message;
DROP TABLE IF EXISTS inbound_message;

CREATE TABLE outbound_message (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  username VARCHAR(50) NOT NULL
);

CREATE TABLE inbound_message (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  username VARCHAR(50) NOT NULL
);

--INSERT INTO outbound_message (id ,content) VALUES (2, 'Welcome to basic h2 chat!');