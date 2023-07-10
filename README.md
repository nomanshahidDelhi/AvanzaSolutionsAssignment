# AvanzaSolutionsAssignment
Online Bookstore Shopping Cart  

Softwares Required For Project execution:
Jdk 11
Maven
Postman


1. After cloning the project, build the project using "mvn clean install" command on GIT Bash.
2. After building Run the project and Login/SignUp by passing appropriate request body in POSTMAN.
3. For SignIn Mobile number and password is required.
4. We can add books to cart.
5. Then finally Checkout order, which returns the total payable amount.
   


To see the test coverage:  
AvanzaSolutionsBookStore->target->site->jacoco->index.html(open in browser)  






SignUP URL:
localhost:8080/api/signup/user

Request:
{
"name":"noman",
"email":"test1@gmail.com",
"mobile":"999999999",
"password":"123456789"
}

Response:
{
    "id": 0,
    "name": "noman",
    "email": "test1@gmail.com",
    "password": "123456789",
    "created_at": "2023/07/10 11:23:00",
    "mobile": "999999999"
}


Login URL:
localhost:8080/api/login/user

Request:
{
"mobile":"987654321",
"password":"123456789"
}

Response:
{
    "user_profile_details": {
        "user_id": "8",
        "name": "noman shahid",
        "mobile": "987654321",
        "email": "test@gmail.com"
    },
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI4IiwiaWF0IjoxNjg4OTcxNzQ0LCJleHAiOjE2ODk1NzY1NDR9.hebP7hn9PSUgwlbZ3mctSpEVTD8_sEO_GiXkJNBnqmvYrPnzY21bNF_RdlGSrRSyI3c1MipPflkEb148xkPdLw"
}

--------------------------------------------------------------------------------
Add Books to cart URL:
localhost:8080/api/addtocart/addBook

Request:
{
"bookId":"1",
"userId":"8",
"qty":"2",
"price":"1400"
}

Response:
[
    {
        "id": 25,
        "qty": 2,
        "price": 1400.0,
        "user_id": 8,
        "added_date": "2023-07-10 11:19:49"
    },
    {
        "id": 26,
        "qty": 2,
        "price": 1400.0,
        "user_id": 8,
        "added_date": "2023-07-10 11:21:20"
    }
]
------------------------------------------------
Checkout Cart URL:

Request:
{
"userId":"8",
"pay_type":"COD",
"deliveryAddress":"Sharjah"
}


Response:
{
    "message": "Order placed successfully",
    "token": "",
    "data": {
        "total_payable_amount": "4200.0"
    }
}

=========================================================================
