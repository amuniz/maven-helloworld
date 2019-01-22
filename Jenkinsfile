stage 'Compile'
node {
  sh 'echo Hello'
}

stage 'Test'

stage 'Code Quality'

stage name: 'Deploy', concurrency: 1
echo 'Finish'
node {
  sh 'echo Hello'
}
