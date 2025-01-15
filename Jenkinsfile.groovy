tools {
    jdk 'JDK21'
    maven 'Maven'
}

options {
    timestamps()
    disableConcurrentBuilds()
    skipDefaultCheckout(true)
}

stages {
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
                sh "mvn clean compile -P${AMBIENTE}"
            }
        }
    }

    stage('Test') {
        steps {
            script {
                try {
                    sh "mvn test -P${AMBIENTE}"
                } finally {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    stage('Package') {
        steps {
            script {
                sh "mvn package -DskipTests -P${AMBIENTE}"
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
