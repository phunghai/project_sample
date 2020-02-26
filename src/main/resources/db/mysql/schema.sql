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

# table for vehicle registration palates  
 CREATE TABLE IF NOT EXISTS `demo_db`.`m_province_type` (
  `cd` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`cd`));

CREATE TABLE IF NOT EXISTS `demo_db`.`m_province` (
  `cd` VARCHAR(10) NOT NULL,
  `type_cd` VARCHAR(10) NULL,
  `name` VARCHAR(150) NULL,
  `name_en` VARCHAR(150) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`cd`),
  UNIQUE INDEX `cd_UNIQUE` (`cd` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `demo_db`.`province_plates` (
  `cd` VARCHAR(10) NOT NULL,
  `value` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cd`));


CREATE TABLE IF NOT EXISTS `demo_db`.`province_plates` (
  `id` BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cd` VARCHAR(10) NOT NULL,
  `value` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `demo_db`.`vehicle_registration_plates` (
  `id` BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `province_cd` VARCHAR(10) NOT NULL,
  `palate_cd` VARCHAR(10) NOT NULL,
  `published` SMALLINT(1) NULL,
  PRIMARY KEY (`id`));


  