-- liquibase formatted sql

-- changeset asavershin:createTables

CREATE TABLE IF NOT EXISTS seasons
(
  season_id       uuid PRIMARY KEY,
  start_date      DATE NOT NULL,
  end_date        DATE NOT NULL,
  description     VARCHAR(256),
  organization_id uuid
);

CREATE TABLE if not exists fields
(
  field_id    uuid PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  description VARCHAR(256),
  season_id   uuid,
  FOREIGN KEY (season_id) REFERENCES seasons (season_id)
);

CREATE TABLE IF NOT EXISTS contours
(
  contour_id  uuid PRIMARY KEY,
  square_area VARCHAR(40) NOT NULL,
  geom        GEOMETRY    NOT NULL,
  description VARCHAR(256),
  color       VARCHAR(6)  NOT NULL,
  field_id    uuid        not null,
  FOREIGN KEY (field_id) REFERENCES fields (field_id)
);

CREATE TABLE if not exists crop_rotations
(
  crop_rotation_id uuid PRIMARY KEY,
  contour_id       uuid,
  FOREIGN KEY (contour_id) REFERENCES contours (contour_id),
  start_date       DATE NOT NULL,
  end_date         DATE NOT NULL,
  culture          VARCHAR(20),
  cultivar         VARCHAR(20),
  description      VARCHAR(256)
);

CREATE TABLE if not exists soil_compositions
(
  soil_composition_id uuid PRIMARY KEY,
  contour_id          uuid NOT NULL,
  FOREIGN KEY (contour_id) REFERENCES contours (contour_id),
  ph                  VARCHAR(10),
  sample_date         DATE NOT NULL,
  organic_matter      VARCHAR(10),
  mobile_p            VARCHAR(10),
  mobile_k            VARCHAR(10),
  mobile_s            VARCHAR(10),
  nitrate_n           VARCHAR(10),
  ammonium_n          VARCHAR(10),
  hydrolytic_acidity  VARCHAR(10),
  ca_exchange         VARCHAR(10),
  mg_exchange         VARCHAR(10),
  b                   VARCHAR(10),
  co                  VARCHAR(10),
  mn                  VARCHAR(10),
  zn                  VARCHAR(10)
);








