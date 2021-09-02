pipeline {
    agent none
    stages {
        stage('Compile') {
            agent {
                label 'linux-default'
            }
            steps {
                checkout scm
                sh 'cat pom.xml'
            }
        }
    }
}
