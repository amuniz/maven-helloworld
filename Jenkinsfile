podTemplate(
  yaml: '''
  apiVersion: v1
  kind: Pod
  spec:
    containers:
    - name: maven
      # In a real Jenkinsfile, it is recommended to pin to a specific version and use Dependabot or Renovate to bump it.
      image: maven:latest
      resources:
        requests:
          memory: "256Mi"
        limits:
          memory: "512Mi"
      command:
      - sleep
      args:
      - infinity
      securityContext:
        # maven runs as root by default, it is recommended or even mandatory in some environments (such as pod security admission "restricted") to run as a non-root user.
        runAsUser: 1000
  '''
) {
    node(POD_LABEL) {
      checkout scm
      sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false install -Diterations=1'
    }
}