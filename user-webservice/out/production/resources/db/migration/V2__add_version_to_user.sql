ALTER TABLE User ADD COLUMN VERSION INT;
UPDATE User SET VERSION = 0;
