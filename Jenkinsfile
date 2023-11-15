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
            withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
              sh 'mvn --batch-mode --errors --no-transfer-progress -Dspotbugs.skip=true install -DskipTests'
            }

          }
        }

        stage('Windows') {
          agent {
            label 'linux-default'
          }
          steps {
            checkout scm
            withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
              sh 'mvn --batch-mode --errors --no-transfer-progress -Dspotbugs.skip=true install -DskipTests'
            }

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
        withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
          sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
          recordIssues(tool: spotBugs(), qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]])
        }

      }
    }

    stage('Release') {
      agent {
        label 'linux-default'
      }
      when {
        beforeAgent true
        beforeInput true
        branch 'master'
      }
      input {
        message 'Do you want to proceed with release?'
      }
      steps {
        checkout scm
        withMaven(jdk: 'jdk-8u242', maven: 'maven-3.6.3') {
          sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
        }

      }
    }

  }
  options {
    buildDiscarder(logRotator(numToKeepStr: "${env.CHANGE_ID == null ? '100' : '5'}", artifactNumToKeepStr: "${env.CHANGE_ID == null ? '5' : '1'}"))
    skipDefaultCheckout()
  }
}