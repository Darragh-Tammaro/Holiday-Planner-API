# Holiday Planner API
 
A RESTful API built with Java and Spring Boot for planning and managing holidays and hotel accommodations. Data is persisted using PostgreSQL with a relational data model linking hotels to their respective holidays.
 
## Tech Stack
 
- **Java** — Core application language
- **Spring Boot** — Framework for building the REST API
- **Spring Data JPA** — Database interaction and ORM
- **PostgreSQL** — Relational database for persistent storage
- **Hibernate** — Auto-generates and manages database schema
- **Maven** — Dependency management
- **Postman** — API testing
## Features
 
- Full CRUD operations for holidays and hotels
- Relational data model — hotels are linked to a parent holiday via a foreign key
- Cascade delete — deleting a holiday automatically removes all associated hotels
- Auto schema generation — Hibernate creates and manages database tables on startup
## Endpoints
 
### Holidays
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/holidays` | Retrieve all holidays |
| GET | `/holidays/{id}` | Retrieve a holiday by ID |
| POST | `/holidays` | Create a new holiday |
| PUT | `/holidays/{id}` | Update an existing holiday |
| DELETE | `/holidays/{id}` | Delete a holiday and its hotels |
 
### Hotels
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/hotels` | Retrieve all hotels |
| GET | `/hotels/{id}` | Retrieve a hotel by ID |
| POST | `/hotels` | Create a new hotel linked to a holiday |
| PUT | `/hotels/{id}` | Update an existing hotel |
| DELETE | `/hotels/{id}` | Delete a hotel |
 
## Data Models
 
### Holiday
```json
{
    "destination": "Ibiza",
    "startDate": "2026-07-01",
    "endDate": "2026-07-14",
    "numberOfPeople": 6,
    "budget": 3000.00
}
```
 
### Hotel
```json
{
    "name": "Hotel Paradiso",
    "pricePerNight": 120.00,
    "numberOfRooms": 3,
    "holiday": {
        "id": 1
    }
}
```
 
## Getting Started
 
### Prerequisites
 
- Java 21+
- PostgreSQL
- Maven
### Setup
 
1. Clone the repository
```bash
git clone https://github.com/Darragh-Tammaro/holiday-planner-api.git
cd holiday-planner-api
```
 
2. Create a PostgreSQL database
```sql
CREATE DATABASE holiday_planner;
```
 
3. Configure your database credentials in `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/holiday_planner
spring.datasource.username=postgres
spring.datasource.password=your_password
```
 
4. Run the application
```bash
./mvnw spring-boot:run
```
 
The API will be available at `http://localhost:8080`
 
## Project Structure
 
```
src/main/java/com/darragh/holiday_planner_api/
│
├── controller/
│   ├── HolidayController.java
│   └── HotelController.java
│
├── model/
│   ├── Holiday.java
│   └── Hotel.java
│
├── repository/
│   ├── HolidayRepository.java
│   └── HotelRepository.java
│
├── service/
│   ├── HolidayService.java
│   └── HotelService.java
│
└── HolidayPlannerApiApplication.java
```
 
