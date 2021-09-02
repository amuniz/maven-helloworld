pipeline {
    agent none
    stages {
        stage('Compile') {
            agent {
                label 'linux-default'
            }
            steps {
                checkout scm
                withCredentials([usernamePassword(credentialsId: 'github-amuniz-token', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'cat pom.xml'
                }
            }
        }
    }
}
