pipeline {
  agent any

  stages {
    stage('checkout'){
        step{
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
  }
}