# Dela-Rosa-Lance-Edward-V.---OOP-Final-Project
My Final Project for the first semester of my second year in College as BSIT Student 


# Health Tracking System

## Introduction

The **Health Tracking System** is a comprehensive platform designed to help users monitor and improve their physical and mental well-being. The system allows users to track key health metrics such as weight, BMI, heart rate, mood, stress levels, and more. It empowers users to set fitness goals, monitor their progress, and reflect on their health journey through personalized insights.

The system incorporates **Object-Oriented Programming (OOP)** principles and integrates a relational **MySQL** database to store user data, including health records, profile information, and activity logs.

This project aligns with **Sustainable Development Goal (SDG) 3: Good Health and Well-being**, as it encourages individuals to take charge of their health and fosters awareness about the importance of maintaining a healthy lifestyle.

## Technologies

- **Programming Language**: Java
- **Libraries**: JDK 8+, MySQL (for database integration)
- **Database**: MySQL
- **Development Tools**: IntelliJ IDEA, Git, GitHub
- **Version Control**: Git

## Features

### 1. **User Profile Management**
   - Users can create and manage their profiles.
   - The system stores personal information such as name, date of birth, and health history.
   - Profile updates are saved and fetched from the database.

### 2. **Health Tracking**
   - **Physical Health**: Track vital health metrics, including weight, height, heart rate, and BMI. Users can add entries to monitor their progress over time.
   - **Mental Health**: Users can track mood, stress levels, and mental health symptoms. The system provides a journaling feature for reflection and mindfulness exercises.

### 3. **Health Insights**
   - The system provides personalized health insights based on entered data, including:
     - **BMI Status**: Categorizes the user's weight status (e.g., underweight, normal weight, overweight, obese).
     - **Blood Pressure Status**: Evaluates the user's blood pressure levels (e.g., normal, elevated, high).
     - **Heart Rate Status**: Indicates if the user's heart rate is normal, low, or high based on the recorded data.

### 4. **History and Data Visualization**
   - Users can view a history of their physical health records, including weight, BMI, heart rate, and blood pressure.
   - Data is stored with the date of entry for easy tracking over time.

### 5. **Goal Setting and Tracking**
   - Users can set fitness goals and track progress, including weight and exercise routines.

### 6. **Sustainable Development Goal (SDG) Integration**
   - The system supports **SDG 3: Good Health and Well-being** by promoting healthy habits and offering personalized health tracking tools that encourage better decision-making and overall wellness.

## How It Works

1. **User Registration**: 
   - Users can sign up by providing their username, password, full name, and date of birth.
   
2. **Dashboard**: 
   - After logging in, users are presented with a dashboard that offers different sections for **Physical Health**, **Mental Health**, and **Profile Management**.
   
3. **Data Entry**: 
   - Users can enter physical health data (e.g., weight, height, heart rate) and mental health data (e.g., mood, stress levels).
   
4. **Health Insights**: 
   - Based on the entered data, the system calculates and provides insights on BMI, heart rate, and blood pressure status.
   
5. **View History**: 
   - Users can access a history of their physical health entries to track progress over time.
   
6. **Profile Updates**: 
   - Users can update their profile details anytime from the Profile section.

## Technologies Used

- **Java**: For building the core logic and object-oriented design.
- **MySQL**: For managing user data and health records.
- **JDBC**: For database connectivity.
- **OOP Principles**: The system utilizes core OOP principles such as inheritance, encapsulation, and polymorphism to manage health-related data efficiently.

## SDG Integration

This project directly aligns with **SDG 3: Good Health and Well-being**, which emphasizes the importance of health and well-being for all ages. By providing users with tools to track their physical and mental health, this system encourages individuals to take proactive steps towards improving their well-being. It supports the following:

- **Monitoring health**: Users are encouraged to track their health metrics, including BMI, heart rate, and stress levels, to identify areas for improvement.
- **Promoting healthy lifestyle choices**: The system helps users set fitness goals, track their progress, and visualize their health journey.

## Instructions for Running the Program

### Prerequisites

- **Java**: Ensure that JDK 8+ is installed on your machine.
- **MySQL**: Install MySQL on your system and set up a local database.
- **Database Configuration**: Modify the `config/db.properties` file to include your local MySQL database credentials.

### Steps to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/health-tracking-system.git
