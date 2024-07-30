CREATE TABLE message
(
    id                            BIGINT NOT NULL,
    looking_for_a_job             BOOLEAN,
    looking_for_a_job_description VARCHAR(255),
    full_name                     VARCHAR(255),
    contact_id                    BIGINT,
    github                        VARCHAR(255),
    vk                            VARCHAR(255),
    facebook                      VARCHAR(255),
    instagram                     VARCHAR(255),
    twitter                       VARCHAR(255),
    website                       VARCHAR(255),
    youtube                       VARCHAR(255),
    main_link                     VARCHAR(255),
    small                         VARCHAR(255),
    large                         VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE users
(

);
