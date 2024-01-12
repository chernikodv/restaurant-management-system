# Restaurant Management System

**Name:** Dmitriy Chernikov

**Email:** chernikov.d@northeastern.edu

### About/Overview

It is the ultimate application that supports the day-to-day operation of a restaurant. The application mainly focuses on the online dining experience.
It allows customers to perform various actions like logging in, registering, browsing menu categories and items, managing credit cards, placing and canceling orders, and retrieving different statistics
There are `18` exposed HTTP endpoints through which the application functionality could be reached and tested.

### Prerequisites

1) [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2) [Gradle](https://gradle.org/install/)
3) [Docker](https://docs.docker.com/engine/install/)

### Technology stack

1) Java 17, Spring Framework (Core, Data, MVC, Security, Boot)
2) MySQL, Flyway Database Migration
3) Lombok, JWT, OpenAPI 3.0
4) Gradle
5) Docker

### Features
1) `POST /api/accounts/sign-in:` authentication by username and password
2) `POST /api/accounts/sign-up:` sign up by providing personal information
3) `GET /api/categories:` look for menu categories
4) `GET /api/categories/{id}/average-nutrition-facts:` retrieve average nutrition facts for the given category
5) `GET /api/menu-items/?categoryId={id}:` look for menu items for the given category
6) `GET /api/menu-items/{id}/nutrition-facts:` retrieve nutrition facts of the given menu item
7) `GET /api/menu-items/trending:` retrieve trending menu items
8) `GET /api/menu-items/favorites:` retrieve favorite menu items of the authorised user
9) `POST /api/menu-items/favorites:` mark a menu item as favorite
10) `DELETE /api/menu-items/favorites/{menuItemId}:` remove a menu item from favorites
11) `GET /api/credit-cards:` retrieve credit cards of the authorised user
12) `POST /api/credit-cards:` add a credit card to your account
13) `DELETE /api/credit-cards/{id}:` delete a credit card from your account by its id
14) `GET /api/credit-cards/statistics:` retrieve payment statistics for all credit cards in your account
15) `GET /api/online-orders:` retrieve your all online orders
16) `POST /api/online-orders:` create an online order
17) `GET /api/online-orders/{id}/nutrition-facts:` show nutrition facts of the given order
18) `GET /api/online-orders/{id}/payment-details:` show payment details of the given order

### How to Run

1) Make sure `Docker` is running.
2) Open a terminal in any folder you like and run the following commands
3) `git clone https://github.com/chernikaud/restaurant-management-system`
4) `cd restaurant-management-system`
5) `./gradlew clean bootJar` for MacOS/Linux, `gradle clean bootJar` for Windows
6) `docker image build -t restaurant_management_system_backend .`
7) `docker-compose up -d`
8) Open now your favorite browser and go to `http://localhost:8080/restaurant/swagger-ui/index.html` to use Open API 3.0. Take into account the fact that it takes about 1 minute for containers to start.
9) Under `account-controller` you may `sign-up` as a new user and then `sign-in` to the system. Copy an access token from the `sign-in` response. Click the `Authorize` button on the top right and paste the access token when prompted.

### How to Develop

1) Make sure `Docker` is running.
2) Open a terminal in any folder you like and run the following commands
3) `git clone https://github.com/chernikaud/restaurant-management-system`
4) `cd restaurant-management-system`
5) `docker-compose up -d cooking_camel_postgres`
6) Make any changes you want, then run/debug the `edu.northeastern.khoury.ds.RestaurantManagementSystemApplication.java` class
7) Open your favorite browser and go to `http://localhost:8080/restaurant/swagger-ui/index.html` to use Open API 3.0. Take into account the fact that it takes about 1 minute for containers to start.
8) Under `account-controller` you may `sign-up` as a new user and then `sign-in` to the system. Copy an access token from the `sign-in` response. Click the `Authorize` button on the top right and paste the access token when prompted.
