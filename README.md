Для работы с данными используется RestRepository, поэтому эндпойнты для CRUD-операций создаются автоматически, в коде контроллеров их нет.

Создание пользователя: 

curl -i -X  POST -H "Content-Type:application/json" -d '{  "name" : "P1" }' http://localhost:8080/persons

Создание автомобиля: 

curl -i -X  POST -H "Content-Type:application/json" -d '{  "name" : "V1" }' http://localhost:8080/vehicles

Связь пользователя с автомобилем:

curl -i -X GET  "http://localhost:8080/functions/addVehicle?personId=1&vehicleId=1"

Поиск:

curl -i -X GET  "http://localhost:8080/functions/partialSearch?text=P"
