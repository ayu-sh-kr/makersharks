### API Documentation

## Register User

> http://localhost:8080/api/user <br>
> Method: POST <br>
> Content-type: application/json

### Body

```JSON
{
  "name": "User Name",
  "email": "User Email",
  "phone": "User Phone",
  "password": "Password",
  "dob": "User's Data Of Birth"
}    
```


## Fetch User Details
> http://localhost:8080/api/user <br>
> Method: GET <br>

*Return all user in the database without pagination*

## Fetch with Pagination
> http://localhost:8080/api/user/page?page=1&size=10 <br>
> Method: GET <br>
> Parameters Page: page_number, size: page_size


## Application Properties
> Data Base *MySQL* <br>
> Data Base Credentials <br>
> DB_URL <br>
> Db_USERNAME <br>
> DB_PASSWORD
> 