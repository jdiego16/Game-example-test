pipeline {
  agent any

  stages {
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