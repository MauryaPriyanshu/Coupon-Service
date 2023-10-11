#Coupon Service

## Introduction

The Generic Coupon Service is a versatile and easily integrable service that allows companies to manage and offer coupons to their customers on their portals. This Spring Boot-based service provides a set of features for administrators to create, update, and disable coupons, and for users to access active offers based on product brand, category, and current date.

## Features

1. **Create Coupons**: Administrators can create coupons with details including brand, category, offer percentage, offer start date, and offer end date. The service responds with a success or failure message.

2. **Get Active Offers**: Users can retrieve active offers based on product brand, category, and the current date.

3. **Update Offer Percentage**: Administrators have the capability to update the offer percentage for a specific coupon.

4. **Disable Active Offers**: Administrators can disable active offers, preventing them from being used by users.
 
## Technologies Used

- **Spring Boot**: This service is built on the Spring Boot framework, providing a robust and scalable foundation for the application.

- **H2 Database**: We use the H2 in-memory database for data storage, making it suitable for development and testing. Companies can easily replace this with their preferred database system for production use.
