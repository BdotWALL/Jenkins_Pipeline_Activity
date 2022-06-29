pipeline {
  agent any
  stages {

    stage('Build') {
      steps {
        script {
          echo 'Hello World!'
        }
      }
    }

    stage('Test') {
      steps {
        script {
          echo 'If you see this, test successful'
        }
      }
    }

  }

  post {
    success {
        mail to: 'brwall92@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "it worked ${env.BUILD_URL}"
    }
}
}