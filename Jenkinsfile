pipeline {
    agent any

    stages {
        stage('Git Clone') {
            steps {
                git credentialsId: 'github-ssh-key', url: 'git@github.com:niko1ai-krasavin/itunes-data-loader.git'
            }
        }
        stage('JUnit') {
            steps {
                sh 'mvn -v'
                sh 'mvn test'
            }
        }
        stage('Docker build') {
            steps {
                sh 'docker version'
                sh 'docker build -t itunes-data-loader:$(git describe --tags) .'
                sh 'docker tag itunes-data-loader:$(git describe --tags) ${PROD_ECR_ENDPOINT}/itunes-data-loader:$(git describe --tags)'
            }
        }
        stage('Push image to ECR') {
            steps {
                sh 'aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin ${PROD_ECR_ENDPOINT}'
                sh 'docker push ${PROD_ECR_ENDPOINT}/itunes-data-loader:$(git describe --tags)'
                sh 'rm /var/lib/jenkins/.docker/config.json'
            }
        }
        stage('Deployment to EKS') {
            environment {
                RDS_CREDENTIALS = credentials('aws-rds-username-password')
                RDS_DB_NAME = credentials('aws-rds-db-name')
            }
            steps {
                sh 'aws eks --region eu-central-1 update-kubeconfig --name ${EKS_CLUSTER_NAME}'
                sh 'helm install itunes-data-loader-$(git describe --tags) helm-chart/ \
                --set env.MYSQL_DB_HOST=${PROD_RDS_ENDPOINT} \
                --set env.MYSQL_DATABASE_NAME=${RDS_DB_NAME} \
                --set env.MYSQL_USERNAME=${RDS_CREDENTIALS_USR} \
                --set env.MYSQL_PASSWORD=${RDS_CREDENTIALS_PSW} \
                --set image=${PROD_ECR_ENDPOINT}/itunes-data-loader:$(git describe --tags) \
                --set countOfReplicas=${COUNT_OF_REPLICAS}'
            }
        }
    }
}