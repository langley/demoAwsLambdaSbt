# demoAwsLambdaSbt
An sbt based project that illustrates how simple it is to write and deploy AWS Lambda functions in Scala with sbt and its plugins


The scala code uses an S3 event and was described in
[this article](https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/)
written by the Tim Wagner, AWS Lambda General Manager and Sean
Reque an AWS Lambda Software Developer. 
       
The gilt.sbt plugin makes it VERY EASY to create and update the plugin!
    
To use this project, just do a createLambda or updateLambda from
sbt. See the github project for the [sbt-aws-lambda plugin](https://github.com/gilt/sbt-aws-lambda)
for details about Lambda settings.
    
sbt-aws-lambda can be configured using sbt settings, environment
  variables or by reading user input at deploy time. For example if
  you use this project as published, sbt will prompt you for the s3
  bucket to use and query you as to the IAM role to use for your
  lambda function. 

| sbt setting   |      Environment variable      |  Description |
|:----------|:-------------:|:------|
| s3Bucket |  AWS_LAMBDA_BUCKET_ID | The name of an S3 bucket where the lambda code will be stored |
| lambdaName |    AWS_LAMBDA_NAME   |   The name to use for this AWS Lambda function. Defaults to the project name |
| handlerName | AWS_LAMBDA_HANDLER_NAME |    Java class name and method to be executed, e.g. `com.gilt.example.Lambda::myMethod` |
| roleArn | AWS_LAMBDA_IAM_ROLE_ARN |The [ARN](http://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html "AWS ARN documentation") of an [IAM](https://aws.amazon.com/iam/ "AWS IAM documentation") role to use when creating a new Lambda |
| region |  AWS_REGION | The name of the AWS region to connect to. Defaults to `us-east-1` |
| awsLambdaTimeout |            | The Lambda timeout in seconds (1-300). Defaults to AWS default. |
| awsLambdaMemory |             | The amount of memory in MB for the Lambda function (128-1536, multiple of 64). Defaults to AWS default. |
| lambdaHandlers |              | Sequence of Lambda names to handler functions (for multiple lambda methods per project). Overrides `lambdaName` and `handlerName` if present. | 
