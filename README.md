# demoAwsLambdaSbt
An sbt based project that demonstrates how simple it is to write and
  deploy [AWS Lambda functions](https://aws.amazon.com/lambda/) in
  [scala](http://scala-lang.org/documentation/) 
  thanks to [sbt](http://www.scala-sbt.org/0.13/docs/index.html)
  and its plug-ins. 


The scala code in this project was described in
  [this article](https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/)
  written by Tim Wagner, AWS Lambda General Manager and Sean
  Reque an AWS Lambda Software Developer. 
       
The [sbt-aws-lambda plug-in](https://github.com/gilt/sbt-aws-lambda)
  developed by [gilt engineering](http://tech.gilt.com/) makes it
  VERY EASY to create and update AWS Lambda functions. 
    
To use this project, just do a git clone and then use the
  createLambda or updateLambda tasks from sbt. See the
  [sbt-aws-lambda github project](https://github.com/gilt/sbt-aws-lambda)
  for more details.
    
The sbt-aws-lambda plug-in can be configured using sbt settings,
  environment variables or by reading user input at deploy time. For
  example if you use this project as published, sbt will prompt you
  for the s3 bucket to use and query you as to the IAM role to use for
  your lambda function.

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

__Note:__ your aws credentials will be picked up as normal if you use
  the [aws cli](https://aws.amazon.com/cli/) as plug-in uses the
  [AWS SDK for Java](https://aws.amazon.com/sdk-for-java/). 
