pipeline {
  agent any

  environment {
    // FOO will be available in entire pipeline
   set FOO = "PIPELINE"
  }

  stages {
    stage("local") {
      environment {
        // BAR will only be available in this stage
      set  BAR = "STAGE"
      }
      steps {
       // sh 'echo "FOO is $FOO and BAR is $BAR"'
	    batchFile( "echo FOO is %FOO% and BAR is %BAR%" ) 
      }
    }
    stage("global") {
      steps {
        batchFile( "echo FOO is %FOO% and BAR is %BAR%" )
      }
    }
  }
}
