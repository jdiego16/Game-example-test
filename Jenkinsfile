pipeline {
  agent any

  stages {
    stage('checkout'){
        steps {
            git branch: 'master', credentialsId: 'Jenkins-Credential-ssh', url: 'git@github.com:jdiego16/Game-example-test.git'

        }
    }
    stage('Quality Analysis') {
      steps {
        script{
            def scannerHome = tool 'sonarqube';
            withSonarQubeEnv('sonarqube') {
            sh "${scannerHome}/bin/sonar-scanner"
            }
        }
      }
    }
    stage("Quality Gate") {
            steps {
                timeout(time: 2, unit: 'minute') {
                    waitForQualityGate abortPipeline: true
                }
            }
    }
}