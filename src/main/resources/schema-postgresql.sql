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

ALTER TABLE employer_posts OWNER TO "user";

SELECT * FROM employer_posts;
