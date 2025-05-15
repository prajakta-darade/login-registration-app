# Login & Registration Application

This is a full-stack web application implementing user registration, login, dashboard, and logout features using React (frontend) and Spring Boot (backend) with session-based authentication.

---

## Features

- User Registration with validations (email format, password length, lowercase letter)
- User Login with session management
- Dashboard displaying logged-in user information
- Logout functionality
- Backend API built with Spring Boot
- Frontend built with React.js
- Session-based authentication with HttpSession
- CORS enabled for React frontend running on localhost:3000

---

## Tech Stack

- Frontend: React.js, Axios, React Router
- Backend: Java Spring Boot, Spring MVC, Spring Data JPA, MySQL
- Session Management: HttpSession
- Development Tools: VS Code, Spring Tool Suite (STS), Postman
  

### Backend Setup

1. Clone the repository or download the backend folder.
2. Import the Spring Boot project into your IDE 
3. Configure your database settings in `application.properties`.
4. Run the Spring Boot application (default port or use any other port 4343).
5. Backend APIs:
   - POST `/register` — Register a new user
   - POST `/login` — User login
   - GET `/dashboard` — Get logged-in user info
   - POST `/logout` — Logout user

### Frontend Setup

1. Navigate to the React frontend folder.
2. Run `npm install` to install dependencies.
3. Run `npm start` to start the development server (default port: 3000).
4. The app will open in your browser at [http://localhost:3000](http://localhost:3000).

---

## Usage

1. Register a new user with valid details.
2. Login with registered credentials.
3. View the dashboard page showing your name and email.
4. Use the logout button to end the session.

---

## Notes

- Make sure backend is running on port `4343` as configured in frontend API calls.
- Enable cookies and session support in your browser or Postman to maintain sessions.
- Adjust CORS settings in Spring Boot if frontend is served from a different origin.

---

## Screenshots

---

## License



---

## Author



---

