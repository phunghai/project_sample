 -- User user@email.pass/pass
INSERT INTO users (name, email, password, enabled)
  values ('user',
    'user@email.com',
    '$2a$04$oUXt9Rufs5s1v37Z/Qe2Su9QJyqnhwEpxxQEPoHNg41I9XNq0g0Bm',
    1);
INSERT INTO users (name, email, password, enabled)
  values ('demo',
    'demo@email.com',
    '$2a$04$oUXt9Rufs5s1v37Z/Qe2Su9QJyqnhwEpxxQEPoHNg41I9XNq0g0Bm',
    1);

INSERT INTO authorities (authority)
  values ('ROLE_ADMIN');

INSERT INTO authorities (authority)
  values ('ROLE_USER');
  
INSERT INTO authorities_users (user_id, authority_id)
  values (1, 1);
INSERT INTO authorities_users (user_id, authority_id)
  values (2, 2);