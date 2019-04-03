FROM mysql:latest
ADD ./sql/dump.sql /docker-entrypoint-initdb.d