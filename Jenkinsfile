pipeline {
    agent any
    stages {
        stage('Build') {
            environment {
                DB_DATABASE = credentials('swacademy-database-url')
                DB_USER = credentials('swacademy-database-user')
                DB_PASSWORD = credentials('swacademy-database-password')
            }
            steps {
                sh '''
                    touch src/main/resources/env.properties
                    echo "DB_DATABASE=$DB_DATABASE" >> src/main/resources/env.properties
                    echo "DB_USER=$DB_USER" >> src/main/resources/env.properties
                    echo "DB_PASSWORD=$DB_PASSWORD" >> src/main/resources/env.properties
                '''
                sh './gradlew clean build'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo "Let\'s Deploy!"'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
        }
    }
}
