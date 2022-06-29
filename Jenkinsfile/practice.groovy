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
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}