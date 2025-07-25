def buildApp() {
    echo 'Building the Application'
}

def buildJar() {
    echo "building the application..."
    sh "mvn package"
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo',passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t fnjauke/demo-app:jma-2.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh " docker push fnjauke/demo-app:jma-2.0"
    }
}

def testApp() {
    echo 'Running tests...'
}

def deployApp() {
    echo 'Deploying the application...'
    echo "Deploying version ${params.VERSION}"
}

return this
