
# --- !Ups

CREATE TABLE IF NOT EXISTS projects (
  id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS languages (
  id SERIAL PRIMARY KEY,
  code varchar (5) NOT NULL
);


CREATE TABLE IF NOT EXISTS projects_translations (
  id SERIAL PRIMARY KEY,
  name varchar (50) DEFAULT '',
  project_id INT NOT NULL,
  language_id INT NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
  FOREIGN KEY (language_id) REFERENCES languages(id) ON DELETE CASCADE
);

INSERT INTO languages (id,code) VALUES (100,'en');
INSERT INTO languages (id,code) VALUES (200,'fr');

INSERT INTO projects VALUES (default);
INSERT INTO projects VALUES (default);


# --- !Downs

DROP TABLE IF EXISTS languages CASCADE;
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS projects_translations CASCADE;


