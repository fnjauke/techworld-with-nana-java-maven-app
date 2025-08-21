
pipeline {
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "Testing the application..."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "building the application..."
                }
            }
        }

        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                	def dockerComposeCmd = "docker compose -f docker-compose.yml up --detach"
                    sshagent(['ec2-server-key']) {
                        sh "scp docker-compose.yml ubuntu@3.91.86.65:/home/ubuntu"
                    	sh "ssh -o StrictHostKeyChecking=no ubuntu@3.91.86.65 ${dockerComposeCmd}"
                    }
                }
            }
        }
    }   
}
