CREATE TABLE  "way" (
	"id" INT PRIMARY KEY,
	"imprint" VARCHAR(64) NOT NULL,
	"way" TEXT NOT NULL,
	"is_first" bool NOT NULL DEFAULT TRUE,
	"start_time" TIMESTAMP NOT NULL,
	"end_time" TIMESTAMP NOT NULL
);


CREATE TABLE  "imprint" (
	"browser_imprint" VARCHAR(64) PRIMARY KEY,
	"unique_imprint" VARCHAR(64) NOT NULL,
	"login" VARCHAR(10) NOT NULL
);