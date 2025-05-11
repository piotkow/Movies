    pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'
    }
    environment {
        SONAR_TOKEN = credentials('sonarqube')
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/piotkow/Movies.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn clean verify sonar:sonar'
                }
            }
        }
        
    }
}
    }
}
