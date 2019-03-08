-- DROP TABLE employer_posts;

CREATE TABLE IF NOT EXISTS employer_posts(
    id SERIAL NOT NULL,
    employer_name TEXT NOT NULL,
    address TEXT NOT NULL,
    position TEXT NOT NULL,
    benefits TEXT NOT NULL,
    apply_url TEXT,
    posted_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS admin_comments(
    id SERIAL NOT NULL,
    title TEXT,
    description TEXT NOT NULL,
    post_id int REFERENCES employer_posts (id)
)

ALTER TABLE employer_posts OWNER TO "user";

SELECT * FROM employer_posts;
