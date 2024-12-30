CREATE TABLE todos(
    id SERIAL NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    CONSTRAINT PK_TODOS PRIMARY KEY (id)
);