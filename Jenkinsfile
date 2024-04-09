pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/caominhnhut/coffeeshopbe.git'
            }
        }
        stage('Docker Build and Push Image') {
            steps {
                withDockerRegistry(credentialsId: 'caa6d4c5-cd73-41a2-ab12-7b103c312c35', url: 'https://index.docker.io/v1/') {
                    sh 'docker-compose up --build'
                    sh 'docker push nguyencaominhnhut/coffeeshopbe:v1'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}