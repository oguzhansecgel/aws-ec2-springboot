pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'oguzhansecgel/aws-ec2-springboot'
        DOCKER_REGISTRY = 'docker.io'
        DOCKER_CREDENTIALS = 'dockerhub-credentials'  // Docker credentials ID
    }

    stages {
        stage('Checkout') {
            steps {
                            checkout scm: [
                                $class: 'GitSCM',
                                branches: [[name: '*/main']],
                                userRemoteConfigs: [[url: 'https://github.com/oguzhansecgel/aws-ec2-springboot.git']]
                            ]
                        }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('https://docker.io', DOCKER_CREDENTIALS) {
                        docker.image(DOCKER_IMAGE).push('latest')
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Docker push completed successfully.'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
