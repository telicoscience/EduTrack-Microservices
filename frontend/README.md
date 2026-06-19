# EduTrack Frontend

Frontend application for the EduTrack educational management platform.

## Overview

EduTrack is a microservices-based educational management system designed to support schools in managing students, classrooms, grades, attendance, and academic information.

This frontend provides the user interface for interacting with the backend services.

Current backend services:

* Student Service
* Classroom Service

## Technologies

* React
* Vite
* JavaScript
* HTML5
* CSS3

## Project Structure

```text
src/
├── assets/
├── components/
├── pages/
├── services/
├── App.jsx
└── main.jsx
```

## Running the Project

### Install dependencies

```bash
npm install
```

### Start development server

```bash
npm run dev
```

The application will be available at:

```text
http://localhost:5173
```

## Backend Services

The frontend communicates with the following APIs:

### Student Service

```text
http://localhost:8081
```

Available endpoints:

* GET /students
* GET /students/{id}
* POST /students
* PUT /students/{id}
* DELETE /students/{id}

### Classroom Service

```text
http://localhost:8082
```

Available endpoints:

* GET /classrooms
* GET /classrooms/{id}
* POST /classrooms
* PUT /classrooms/{id}
* DELETE /classrooms/{id}

## Development Status

Implemented:

* Student CRUD backend
* Classroom CRUD backend
* Unit tests
* OpenAPI / Swagger documentation

In Progress:

* Frontend screens
* API integration
* Navigation and routing

Planned Features:

* Authentication and authorization
* Attendance management
* Grade management
* Teacher management
* Dashboard and analytics
* Responsive design
* Production deployment

## Related Services

This frontend is part of the EduTrack Microservices project:

* student-service
* classroom-service

## Author

Télico Oliveira
