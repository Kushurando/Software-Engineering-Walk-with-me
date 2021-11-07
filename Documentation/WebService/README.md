## WebService API Documentation

### Framework

[Spring Framework](https://spring.io/) --- [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
___
## API Documentation

### API Call URLs
> https://localhost/api/

> https://walkwithme.com/api/

### API layout
> /api/{api_key}/{version}/{module}/{function}{parameters}
___
### User API (_/api/{key}/v1/users_)

#### Creating a new user
```html
POST /newUser?username={username}&password={password}
```
```text
"done"
```
#### Deleting a user
```html
POST /deleteUser?id={id}
```
```text
"done"
```
#### Getting all users
```html
POST /getUsers
```
```json
{
  "id": 2,
  "username": "frankie",
  "password": "itsmeagain41",
  "email": "test@hotmail.com",
  "create_time": null
}
{
  "id": 5,
  "username": "dubsky",
  "password": "testPW",
  "email": "test@gmail.com",
  "create_time": null
}
```
#### Find user by ID
```html
POST /findByID?id={id}
```
```json
{
  "id": 5,
  "username": "dubsky",
  "password": "testPW",
  "email": "test@gmail.com",
  "create_time": null
}
```
#### Find user by username
```html
POST /findByUsername?username={username}
```
```json
{
  "id": 5,
  "username": "dubsky",
  "password": "testPW",
  "email": "test@gmail.com",
  "create_time": null
}
```
#### Find user by email
```html
POST /findByEmail?email={email}
```
```json
{
  "id": 5,
  "username": "dubsky",
  "password": "testPW",
  "email": "test@gmail.com",
  "create_time": null
}
```
#### Changing user email
```html
POST /changeEmail?id={id}&email={new_email}
```
```text
"done"
```
#### Changing user password
```html
POST /changePassword?id={id}&password={new_password}
```
```text
"done"
```
### Relation API

#### Getting a relationship
```html
GET /getRelation?id={id}&id2={id2}
```
```json
{
  "id_first": 1,
  "id_second": 4,
  "liked": 1,
  "blocked": 0
}
```

#### Creating a relationship
```html
GET /createRelation?id={id}&id2={id2}
```
```text
"done"
```

#### Adding a like
```html
POST /addLike?id={id}&id2={id2}
```
```text
"done"
```

#### Removing a like
```html
POST /removeLike?id={id}&id2={id2}
```
```text
"done"
```

#### Adding a block
```html
POST /addBlock?id={id}&id2={id2}
```
```text
"done"
```
#### Removing a block
```html
GET /removeBlock?id={id}&id2={id2}
```
```text
"done"
```

### Report API