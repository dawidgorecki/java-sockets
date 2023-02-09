```bash
# run database container

docker run --name psql-js \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_USER=dawid \
-e POSTGRES_DB=testdb \
-p 5400:5432 \
-d postgres:15.1
```
