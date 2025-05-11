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
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
