# demoAwsLambdaSbt
This is an sbt based project that demonstrates how simple it is to write and
  deploy [AWS Lambda functions](https://aws.amazon.com/lambda/) in
  [scala](http://scala-lang.org/documentation/)
  thanks to [sbt](http://www.scala-sbt.org/0.13/docs/index.html)
  and its plug-ins!

To use this project
- Start with a git clone of the project
- Then use sbt and the  createLambda or updateLambda tasks from the
  sbt prompt. NOTE: you will be prompted for an S3 bucket for the .jar
  to be put in, you'll need to chose one in your account. _(The bucket name must be all lower case and cannot contain special characters like underscore)_
- Next use the Aws Lambda Management Console test your code. The "trick" here is to select the "S3 Put" event in their template of test events.
- You will see that the code pulls out the value of the field Records.s3.key which is by default "HappyFace.jpg"
- For more advanced AWS operations consider using the [aws java sdk](https://github.com/aws/aws-sdk-java) or the more 'Scala-ey'  [aws-scala-sdk](https://github.com/awslabs/aws-scala-sdk)

For background information about the underlying libraries see the [sbt-aws-lambda github project](https://github.com/gilt/sbt-aws-lambda).

The original scala code inspiration for this project was described in
  [this article](https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/)
  written by Tim Wagner, AWS Lambda General Manager and Sean
  Reque an AWS Lambda Software Developer.

The [sbt-aws-lambda plug-in](https://github.com/gilt/sbt-aws-lambda)
  developed by [gilt engineering](http://tech.gilt.com/) makes it
  VERY EASY to create and update AWS Lambda functions.


Finally, the sbt-aws-lambda plug-in can be configured using sbt settings,
  environment variables or by reading user input at deploy time. For
  example if you use this project as published, sbt will prompt you
  for the s3 bucket to use and query you as to the IAM role to use for
  your lambda function. That's all you really need to get started, but if you want more control you can set the following values.

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
  the [aws cli](https://aws.amazon.com/cli/) as sbt-aws-lambda plug-in
  uses the [AWS SDK for Java](https://aws.amazon.com/sdk-for-java/).
