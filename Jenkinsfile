pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'
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
                withSonarQubeEnv('MySonar') {
                  bat 'sonar-scanner -Dsonar.projectKey=moj-projekt -Dsonar.sources=src'
                }
              }
        }
    }
}
    }
}
