# User Management API

## Docker deploy
```
mvn clean package
docker build -t nc/user-management .
docker run -p 8080:8080 nc/user-management
```