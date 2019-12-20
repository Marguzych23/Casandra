create keyspace if not exists targeted_advertising
with replication = {'class': 'SimpleStrategy', 'replication_factor': 1}
and durable_writes = true;

CREATE TABLE  "uncompleted_way" (
    "imprint" VARCHAR(64) PRIMARY KEY,
	"way" TEXT NOT NULL,
	"start_time" TIMESTAMP NOT NULL
);

CREATE TABLE  "completed_way" (
	"id" INT PRIMARY KEY,
	"imprint" VARCHAR(64) NOT NULL,
	"way" TEXT NOT NULL,
	"is_first" bool NOT NULL DEFAULT TRUE,
	"start_time" TIMESTAMP NOT NULL,
	"end_time" TIMESTAMP NOT NULL
);

CREATE TABLE  "imprint" (
	"id" INT PRIMARY KEY,
	"imprint" VARCHAR(64) NOT NULL,
);