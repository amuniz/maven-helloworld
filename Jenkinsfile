echo "Hello untrusted"
node {
  git 'https://github.com/amuniz/maven-helloworld.git'
  def mvnHome = tool 'maven-3'
  sh "${mvnHome}/bin/mvn clean"
}
