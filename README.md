# TodoList in Spring Boot using PostgreSQL

This project to-do list includes multiple users with their to-do list.
Can `ADD`, `DELETE`, `UPDATE`, see `ALL OPERATİONS`.
You can also see what to do `DAİLY`, `WEEKLY` and `MONTHLY`.
Including `FINISHED` to-dos and `UNFINISHED` to-dos.
<br></br>
![](https://img.shields.io/badge/java-v19-green)
![](https://img.shields.io/badge/spring--boot-v2.7.5-green)
<hr>
<details align="left"> 
<summary>Project Architect</summary><br>

    todolist
    ┣ business
    ┃ ┣ TodoService.java
    ┃ ┗ UserService.java
    ┣ config
    ┃ ┗ GeneralConfig.java
    ┣ controller
    ┃ ┣ TodoListsController.java
    ┃ ┗ UsersController.java
    ┣ dto
    ┃ ┣ todo
    ┃ ┃ ┣ todoRequest
    ┃ ┃ ┃ ┣ TodoAddRequestDto.java
    ┃ ┃ ┃ ┗ TodoUpdateRequestDto.java
    ┃ ┃ ┗ todoResponse
    ┃ ┃ ┃ ┣ AllTodoResponseDto.java
    ┃ ┃ ┃ ┗ TodoResponseDto.java
    ┃ ┗ user
    ┃ ┃ ┣ userRequest
    ┃ ┃ ┃ ┣ UserAddRequestDto.java
    ┃ ┃ ┃ ┗ UserUpdateRequestDto.java
    ┃ ┃ ┗ userResponse
    ┃ ┃ ┃ ┣ AllUserResponseDto.java
    ┃ ┃ ┃ ┗ UserResponseDto.java
    ┣ entities
    ┃ ┣ Todo.java
    ┃ ┗ User.java
    ┣ exception
    ┃ ┣ Messages.java
    ┃ ┣ TodoNotFoundId.java
    ┃ ┗ UserNotFoundId.java
    ┣ repository
    ┃ ┣ TodoRepository.java
    ┃ ┗ UserRepository.java
    ┗ TodolistApplication.java
</details><hr>


## __[GET]__ All To-Do

![todos.png](https://raw.githubusercontent.com/emrahyilm4z/ToDoList/master/images/todos.png)
<hr>


## __[GET]__ All User
![users.png](https://raw.githubusercontent.com/emrahyilm4z/ToDoList/master/images/users.png)

<hr>


## POSTMAN REQUEST
![postman.png](https://raw.githubusercontent.com/emrahyilm4z/ToDoList/master/images/postman.png)
<br></br>

## License

[MIT](https://choosealicense.com/licenses/mit/)
