DROP TABLE IF EXISTS notes;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE notes
(
    id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    title VARCHAR(255),
    description VARCHAR(255)          NOT NULL,
    date_time TIMESTAMP DEFAULT now() NOT NULL,
    made BOOLEAN DEFAULT FALSE        NOT NULL
);
CREATE UNIQUE INDEX notes_id_uindex ON notes (id);
