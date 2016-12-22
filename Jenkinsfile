stage 'Compile'
node('shared') {
    checkout scm
    // use for non multibranch: git 'https://github.com/amuniz/maven-helloworld.git'
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn clean install -DskipTests"
    stash 'working-copy'
}

stage 'Test'
parallel one: {
    node('ssh-agent') {
        unstash 'working-copy'
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn test -Diterations=10"
    }
}, two: {
    node('shared-jnlp-agent') {
        unstash 'working-copy'
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn test -Diterations=5"
    }
}, failFast: true

stage 'Code Quality'
node('shared') {
    unstash 'working-copy'
    step([$class: 'CheckStylePublisher'])
    //step([$class: 'FindBugsPublisher'])
    //step([$class: 'PmdPublisher'])
}

stage name: 'Deploy', concurrency: 1
def path = input message: 'Where should I deploy this build?', parameters: [[$class: 'StringParameterDefinition', name: 'FILE_PATH']]
node('shared') {
    unstash 'working-copy'
    sh "cp target/example-1.0-SNAPSHOT.jar ${path}"
}
