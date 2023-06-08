CREATE TABLE courses (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL
);


CREATE TABLE topics (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  message VARCHAR(255) NOT NULL,
  creationDate DATETIME NOT NULL,
  status VARCHAR(50) NOT NULL,
  author_id BIGINT,
  course_id BIGINT,
  FOREIGN KEY (author_id) REFERENCES users(id),
  FOREIGN KEY (course_id) REFERENCES courses(id)
);


CREATE TABLE replies (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  message VARCHAR(255) NOT NULL,
  topic_id BIGINT,
  creationDate DATETIME NOT NULL,
  author_id BIGINT,
  solution BOOLEAN NOT NULL,
  FOREIGN KEY (topic_id) REFERENCES topics(id),
  FOREIGN KEY (author_id) REFERENCES users(id)
);