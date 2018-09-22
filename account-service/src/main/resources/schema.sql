-- this sql file is not used by the application implicitly i.e. not used by spring data jpa - hibernate on startup
CREATE TABLE account (
    ID INT,
    account_name VARCHAR(50),
    account_description VARCHAR(100)
);