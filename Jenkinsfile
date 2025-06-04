pipeline {
  agent none
  stages {
    stage('Compile') {
      parallel {
        stage('Linux') {
          agent {
            label 'linux-default'
          }
          steps {
            checkout scm
            sh 'mvn --batch-mode --errors --no-transfer-progress -Dspotbugs.skip=true install -DskipTests'
          }
        }
      }
    }

    stage('Test & QA') {
      agent {
        label 'linux-default'
      }
      steps {
        checkout scm
        sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
      }
    }
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: "${env.CHANGE_ID == null ? '100' : '5'}", artifactNumToKeepStr: "${env.CHANGE_ID == null ? '5' : '1'}"))
    skipDefaultCheckout()
  }
}