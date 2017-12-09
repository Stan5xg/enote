DROP ALL OBJECTS;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password_hash` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iduser_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `notepad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
--   INDEX `fk_notepad_1_idx` (`user_id` ASC),
  CONSTRAINT `fk_notepad_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
  )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NULL,
  `content` TEXT NULL,
  `notepad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `note_id_UNIQUE` (`id` ASC),
--   INDEX `fk_note_1_idx` (`notepad_id` ASC),
  CONSTRAINT `fk_note_1`
    FOREIGN KEY (`notepad_id`)
    REFERENCES `notepad` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tag_id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `tag_name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `tag_note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `note_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `tag_note_id_UNIQUE` (`id` ASC),
--   INDEX `fk_TagNote_2_idx` (`note_id` ASC),
--   INDEX `fk_TagNote_1_idx` (`tag_id` ASC),
  CONSTRAINT `fk_TagNote_1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `tag` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TagNote_2`
    FOREIGN KEY (`note_id`)
    REFERENCES `note` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
