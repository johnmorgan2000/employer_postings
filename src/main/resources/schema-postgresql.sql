CREATE TABLE IF NOT EXISTS employer_posts(
    id SERIAL NOT NULL,
    address TEXT NOT NULL,
    postition TEXT NOT NULL,
    benefits TEXT NOT NULL,
    applu_url TEXT,
    posted_date DATE NOT NULl

);

ALTER TABLE employer_posts OWNER TO "user";
-- GRANT ALL ON TABLE applications TO "user";

-- GRANT ALL PRIVILEGES ON DATABASE "application-db" TO "user";

-- INSERT INTO applications (name, email, school, eligible, age, phone, graduation, aptitude, dedication, passion) VALUES ('Cole Anderson', 'fake@email.com', 'Charleston', true, 19, '7775554444', 'None', 'None', 'None', 'None');

-- SELECT * FROM applications;
