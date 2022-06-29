pipeline {
  agent any
  stages {

    stage('Build') {
      steps {
         echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
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