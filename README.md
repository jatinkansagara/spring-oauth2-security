# spring-oauth2-security

1) Execute DB script
2) Perform Gradle build
3) Run Project

#Get Token
POST -- http://localhost:8080/springOauth2/v1/oauth/token
PostMan set basic authorization
				username - test
				password - test123

Request:
{
	"grant_type":"password",
	"username":"admin",
	"password":"secret123"
}

Response : Generate token, refresh token, expired

# Greeting API
POST - http://localhost:8080/springOauth2/greeting
set Header
	"Authorization":"Bearer #generated token#"
	
Response:
Get Greeting message
