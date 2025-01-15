pipeline {
    agent any

    tools {
        jdk 'OpenJDK 11'  // Asegúrate de que 'OpenJDK 11' esté configurado correctamente en Jenkins
        maven 'Maven 3.8.1'  // Asegúrate de que 'Maven 3.8.1' esté configurado correctamente en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Extrae el código desde tu repositorio de Git
                git 'https://github.com/usuario/tu-repositorio.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Ejecutar el comando de Maven para compilar el proyecto
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Ejecutar los tests JUnit usando Maven
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    // Empaquetar el proyecto y generar el archivo .jar
                    sh 'mvn package'
                }
            }
        }

        stage('Archive') {
            steps {
                // Archivar el archivo .jar generado
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            // Esto se ejecutará después de la ejecución de todos los stages (para limpiar, notificar, etc.)
            echo 'Pipeline completed!'
        }

        success {
            // Este bloque se ejecuta si el pipeline fue exitoso
            echo 'Build was successful!'
        }

        failure {
            // Este bloque se ejecuta si el pipeline falló
            echo 'Build failed!'
        }
    }
}
