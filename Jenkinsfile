pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        IMAGE_NAME = 'chatbox'
        IMAGE_TAG  = 'latest'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'hhttps://github.com/akshayjadhav9423/Project102.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker stop chatbox || exit 0'
                bat 'docker rm chatbox || exit 0'
                bat 'docker run -d --name chatbox -p 8182:8182 --network host %IMAGE_NAME%:%IMAGE_TAG%'
            }
        }
    }

    post {
        success { echo 'Pipeline succeeded! App is running on http://localhost:8181' }
        failure { echo 'Pipeline failed. Check logs above.' }
    }
}
