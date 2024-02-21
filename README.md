- [Course](https://www.linkedin.com/learning/learning-spring-6-with-spring-boot-3/run-postgresql?autoSkip=true&resume=false&u=100838786)

## Quick startup

1. Setup local database
   1. `cd docker`
   2. `docker-compose up -d`
   3. Execute script at `docker/postgres/schema.sql`
   4. Execute script at `docker/postgres/data.sql`
2. `./gradlew bootRun`

> Note that environment variables should be in place for the app to properly connect to a database.

## How was this app built?

1. Navigate to https://start.spring.io/ and generate a project
2. Decompress the downloaded .zip file to your project
