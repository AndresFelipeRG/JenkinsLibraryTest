import com.sap.piper.JenkinsUtils
import com.sap.piper.Utils
def call(body){

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    
        if(config.pipelineStageOpaTests){
         pipeline {
            agent any
            stages {
                 stage('Test'){
                     steps {
                    //dockerExecute(dockerImage: 'node:11')
                     dockerExecute(script: this,dockerImage: 'node:11'){
                         sh 'pwd'
                     }
                    }
                }
            }
        }
     }
    
}
