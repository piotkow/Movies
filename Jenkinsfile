pipeline {
    agent any

    tools {
        maven 'Maven_3.8.5'
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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=Movies ^
                        -Dsonar.host.url=%SONAR_HOST_URL% ^
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
