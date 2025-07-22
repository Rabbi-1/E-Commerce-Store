-- This file allows us to load static data into the test database before tests are run.
-- Encrypted using https://www.javainuse.com/onlineBcrypt
INSERT INTO local_user(email, first_name, last_name, password, username, email_verified)
    VALUES ('UserA@junit.com', 'UserA-FirstName', 'UserA-LastName', '$2a$10$wApdShyK430PKjenmCcEH.mMYnTJ.7AeZOb.IIGreWXmlwIVoBHyG', 'UserA', true),
    ('UserB@junit.com', 'UserB-FirstName', 'UserB-LastName', '$2a$10$GZRDV0nYNlDbyPhAGSOVKufvOnn69U.vHXTJaxuxrO7JFLDb.6htm', 'UserB', false)
