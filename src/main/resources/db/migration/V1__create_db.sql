CREATE TABLE IF NOT EXISTS client(
ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
NAME VARCHAR(200) NOT NULL CHECK (LENGTH(NAME) >= 3 AND LENGTH(NAME) <= 200),
);

CREATE TABLE IF NOT EXISTS planet(
ID VARCHAR(30) PRIMARY KEY CHECK (ID ~ '^[A-Z0-9]+$'),
NAME VARCHAR(500) NOT NULL CHECK (LENGTH(NAME) >= 1 AND LENGTH(NAME) <= 500),
);

CREATE TABLE IF NOT EXISTS ticket (
    ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CLIENT_ID INT,
    FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
    FROM_PLANET_ID VARCHAR(30) REFERENCES planet(ID),
    TO_PLANET_ID VARCHAR(30) REFERENCES planet(ID)
);