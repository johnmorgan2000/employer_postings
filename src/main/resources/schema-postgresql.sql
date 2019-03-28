DROP TABLE admin_comments;
DROP TABLE employer_posts;

ALTER DEFAULT PRIVILEGES GRANT ALL ON TABLES TO "user";

CREATE TABLE IF NOT EXISTS employer_posts(
    id SERIAL PRIMARY KEY,
    employer_name TEXT NOT NULL,
    address TEXT NOT NULL,
    position TEXT NOT NULL,
    description TEXT NOT NULL,
    benefits TEXT,
    apply_url TEXT,
    image_url TEXT,
    posted_date TIMESTAMP NOT NULL,
    views INT
);

CREATE TABLE IF NOT EXISTS admin_comments(
    id SERIAL NOT NULL,
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    post_id int REFERENCES employer_posts (id) ON DELETE CASCADE
);

ALTER TABLE employer_posts OWNER TO "user";
ALTER TABLE admin_comments OWNER TO "user";


GRANT ALL ON TABLE employer_posts TO "user";
GRANT ALL ON TABLE admin_comments TO "user";

GRANT ALL PRIVILEGES ON DATABASE "employer-postings-db" TO "user";

-- SELECT * FROM employer_posts;
