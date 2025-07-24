pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '' )
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                // Example build command:
                // sh 'echo Simulating build process'
            }
        }

        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'Running tests...'
                // Example test command:
                // sh 'echo Simulating test run'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                echo "Deploying version ${params.VERSION}"
                // Example deploy command:
                // sh 'echo Simulating deployment'
            }
        }
    }
}
