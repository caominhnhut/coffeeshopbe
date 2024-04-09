pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/caominhnhut/coffeeshopbe.git'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}