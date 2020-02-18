CREATE TABLE IF NOT EXISTS users (
  id bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE KEY email_unique (email)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS authorities (
  id bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  authority VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
   
CREATE TABLE IF NOT EXISTS authorities_users (
  user_id bigint(11) unsigned NOT NULL,
  authority_id bigint(11) unsigned NOT NULL,
  UNIQUE KEY authorities_unique (user_id, authority_id)
) ENGINE = InnoDB 
  DEFAULT CHARSET = utf8mb4;