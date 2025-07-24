def buildApp() {
    echo 'Building the Application'
}


def testApp() {
    echo 'Running tests...'
}

def deployApp() {
    echo 'Deploying the application...'
    echo "Deploying version ${params.VERSION}"
}

return this
