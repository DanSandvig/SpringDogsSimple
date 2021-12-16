DROP TABLE IF EXISTS dog CASCADE;
CREATE TABLE `dog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` bigint DEFAULT NULL,
  `breed` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);