FROM openjdk:17-oracle
ADD /build/libs/restaurant-management-system-*.jar /app.jar
CMD exec java -jar /app.jar