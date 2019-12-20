create keyspace if not exists user_way
with replication = {'class': 'SimpleStrategy', 'replication_factor': 1}
and durable_writes = true;

CREATE TABLE  uncompletedway(
    imprint text PRIMARY KEY,
	way TEXT,
	starttime TIMESTAMP
);

CREATE TABLE  completedway(
	id text PRIMARY KEY,
	imprint text,
	way TEXT,
	isfirst boolean,
	starttime text,
	endtime text
);

CREATE TABLE  imprint(
	id text PRIMARY KEY,
	imprint text,
);