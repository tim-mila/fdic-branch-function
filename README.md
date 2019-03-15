# FDIC Branch Search Function

Micronaut Framework `@FunctionBean` deployed as a AWS Lambda Function that receives requests via an AWS API Gateway and proxies the received inputs to the [FDIC Bank Data API](https://banks.data.fdic.gov/docs/).

```
https://6axu70yfr6.execute-api.us-east-1.amazonaws.com/default/FdicBranchSearch?institutionName=Wells River Savings Bank&q=Bradford*&fields=NAME,OFFNAME,ZIP
```