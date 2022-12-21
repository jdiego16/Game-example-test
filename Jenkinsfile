pipeline {
  agent any
    parameters {
        booleanParam(name: "RELEASE", defaultValue: false)
    }
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
                timeout(time: 5, unit: 'MINUTES') {

                    waitForQualityGate abortPipeline: true
                }
            }
    }
    stage("Publish") {
            steps {
            
                if (params.RELEASE) {
                    sh "echo conditional true"
                }
                
            }


    }
    }
}