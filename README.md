# Simple Test manager

Basic test manager app. Backend and frontend parts

## How to run
```
mvn clean package
cp .env.temp .env
docker-compose -f docker-compose.build.yml up -d --build
```