def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ashrefg/project_pipeline:jma-2.0 .'
        sh '''echo "$PASS" | docker login -u "$USER" --password-stdin'''
        sh 'docker push ashrefg/project_pipeline:jma-2.0'
    }
} 

def testApp() {
    echo 'Testing the application....'
} 

def deployApp() {
    echo 'deploying the application....'
} 

return this
