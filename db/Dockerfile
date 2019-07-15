From postgres:10
ENV POSTGRES_USER bankdb
ENV POSTGRES_PASSWORD bankdb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432