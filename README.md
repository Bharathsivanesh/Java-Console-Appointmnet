# 🏥 Doctor Appointment Booking Portal (Java Console App)

A **Java Console Application** for booking and managing doctor appointments. This project is developed using the **MVC architecture**, and includes **DAO**, **DTO**, and **Singleton Pattern** for better structure, scalability, and separation of concerns. The backend is powered by **MySQL** using **JDBC**.

---

## 📘 Project Definition

### 🧱 MVC Architecture
- **Model**: Contains data and business logic (DTO classes).
- **View**: The UI shown in the console (e.g., `Main.java`, `PatientView.java`, etc.).
- **Controller**: Manages the flow between View and Model (e.g., `AppointmentController.java`).

### 📦 DAO (Data Access Object)
- Handles all database operations such as Insert, Update, Delete, and Select.
- Keeps database logic separate from business logic.

### 📦 DTO (Data Transfer Object)
- Used to carry data between classes and layers.
- A plain object that holds multiple attributes but does not have behavior (methods).

### ♻️ Singleton Pattern
- Ensures that a class has only **one instance** and provides a global point of access to it.
- Used in `DBConnection.java` for consistent database access.

---

## 🎯 Features

### 👑 Admin
- 🔐 Login
- ➕ Add Doctor
- ➕ Add Receptionist

### 🧑‍⚕️ Doctor
- 🔐 Login
- 📅 View Appointments
- 🟢 Update Availability

### 🧑‍💼 Receptionist
- 🔐 Login
- 📆 Schedule Appointments
- ❌ Reject Appointments (based on doctor's availability)

### 🧍 Patient
- 📝 Register
- 🔐 Login
- 🏥 Book Appointments

---

## ⚙️ Technologies Used

| Tech            | Purpose                          |
|-----------------|----------------------------------|
| Java            | Core language                    |
| MySQL           | Backend database                 |
| JDBC            | Java-Database connection         |
| IntelliJ IDEA   | Java IDE                         |
| MVC             | Code organization architecture   |
| DAO/DTO         | Clean separation of concerns     |
| Singleton       | DB connection management         |

---

## 🛠️ How to Run This Project

### 🔧 Prerequisites
- Java JDK installed
- MySQL installed
- IntelliJ IDEA or Eclipse

### 🪜 Steps

1. **Clone the Repo**
   ```bash
   git clone https://github.com/Bharathsivanesh/Java-Console-Appointmnet.git
   cd DoctorAppointment
