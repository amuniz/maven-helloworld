pipeline {
    agent {
        label 'linux-default'
    }
    stages {
        stage('Compile') {
            parallel {
                stage ('Linux') {
                    steps {
                        checkout scm
                        withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
                            sh 'mvn --batch-mode --errors --no-transfer-progress -Dspotbugs.skip=true install -DskipTests'
                        }
                    }

                }
                stage ('Windows') {
                    steps {
                        checkout scm
                        withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
                            sh 'mvn --batch-mode --errors --no-transfer-progress -Dspotbugs.skip=true install -DskipTests'
                        }
                    }
                }
            }
        }
        stage('Test') {
            steps {
                checkout scm
                withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
                    sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
                }
            }
        }
        stage ('Release') {
            input {
                message "Do you want to proceed with release?"
            }
            steps {
                checkout scm
                withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
                    //sh 'mvn --show-version --batch-mode --errors --no-transfer-progress release:prepare release:perform -Diterations=1 -Drelease.arguments="-Diterations=1"'
                    sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
                }
            }
        }
    }
}
