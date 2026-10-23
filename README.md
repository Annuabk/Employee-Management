postman request POST 'http://localhost:8081/api/employees' \
--header 'Content-Type: application/json' \
--body '{
"name": "Annu",
"email": "joe@example.com",
"phoneNumber": "123489272**",
"companyId": "C001",
"siteId": "S001"
}'
{
"timestamp": "2026-10-23T09:47:30.192433",
"status": 400,
"error": "Bad Request",
"errors": {
"phoneNumber": "Phone must be 10 digits"
}
}
postman request POST 'http://localhost:8081/api/employees' \
--header 'Content-Type: application/json' \
--body '{

"email": "joe@example.com",
"phoneNumber": "9877456123",
"companyId": "C001",
"siteId": "S001"
}'
{
"timestamp": "2026-10-23T09:48:08.5218107",
"status": 400,
"error": "Bad Request",
"errors": {
"name": "Name is required"
}
}

postman request POST 'http://localhost:8081/api/employees' \
--header 'Content-Type: application/json' \
--body '{
"name": "Annu",
"email": "joe@example.com",
"phoneNumber": "9877456123",
"companyId": "C001",
"siteId": "S001"
}'

{
"id": "5",
"name": "Annu",
"phoneNumber": "9877456123",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
}

postman request 'http://localhost:8081/api/employees/10'
{
"timestamp": "2026-10-23T09:49:00.7519314",
"status": 404,
"error": "Not Found",
"message": "Employee not found with id: 10"
}
postman request 'http://localhost:8081/api/employees/5'
{
"id": "5",
"name": "Annu",
"phoneNumber": "9877456123",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
}
postman request PUT 'http://localhost:8081/api/employees/5' \
--header 'Content-Type: application/json' \
--body '{"phoneNumber":9823485617}'
{
"id": "5",
"name": "Annu",
"phoneNumber": "9823485617",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
}

postman request POST 'http://localhost:8081/api/employees/search' \
--header 'Content-Type: application/json' \
--body '{
"companyId":"C001"
}'[
{
"id": "4",
"name": "joe",
"phoneNumber": "9823485618",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
},
{
"id": "5",
"name": "Annu",
"phoneNumber": "9823485617",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
}
]
postman request 'http://localhost:8081/api/employees?page=0&size=10&sort=name%2Casc&companyId=C001&siteId=S001'

{
"content": [
{
"id": "5",
"name": "Annu",
"phoneNumber": "9823485617",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
},
{
"id": "4",
"name": "joe",
"phoneNumber": "9823485618",
"email": "joe@example.com",
"status": "ACTIVE",
"companyId": "C001",
"siteId": "S001"
}
],
"pageable": {
"pageNumber": 0,
"pageSize": 10,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"offset": 0,
"paged": true,
"unpaged": false
},
"last": true,
"totalPages": 1,
"totalElements": 2,
"size": 10,
"number": 0,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"first": true,
"numberOfElements": 2,
"empty": false
}

postman request DELETE 'http://localhost:8081/api/employees/3'

Successfully deleted

postman request DELETE 'http://localhost:8081/api/employees/15'
{
"timestamp": "2026-10-23T09:59:47.3619947",
"status": 404,
"error": "Not Found",
"message": "Employee not found with id: 15"
}
