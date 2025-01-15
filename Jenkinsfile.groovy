stages {
    stage{
        sh "mvn --version"
    }
    stage('Limpiar Workspace') {
        steps {
            cleanWs()
        }
    }

    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Build') {
        steps {
            script {
                sh "mvn clean compile"
            }
        }
    }

    stage('Test') {
        steps {
            script {
                try {
                    sh "mvn test"
                } finally {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    stage('Package') {
        steps {
            script {
                sh "mvn package -DskipTests"
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}

post {
    always {
        cleanWs()
    }
    success {
        echo "Build completado exitosamente para ambiente: ${AMBIENTE}"
    }
    failure {
        echo "Build falló para ambiente: ${AMBIENTE}"
    }
}
