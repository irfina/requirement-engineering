CREATE TABLE project (
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(128) NOT NULL,
    description VARCHAR(1024),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
);

CREATE TABLE hashtag (
    id SERIAL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);

CREATE TABLE requirement (
    id UUID DEFAULT uuid_generate_v4(),
    project_id UUID NOT NULL,
    code VARCHAR(64) NOT NULL,
    name VARCHAR(256) NOT NULL,
    description VARCHAR(2048),
    req_date TIMESTAMP NOT NULL,
    priority INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (project_id) REFERENCES project (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE requirement_comment (
    requirement_id UUID NOT NULL,
    seq_number INT NOT NULL,
    comment VARCHAR(2048) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (requirement_id, seq_number),
    FOREIGN KEY (requirement_id) REFERENCES requirement (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE requirement_note (

);

CREATE TABLE requirement_hashtag (

);

CREATE TABLE change_request (
    id UUID,
    request_by VARCHAR(256) NOT NULL,
    requirement_id UUID,

);
