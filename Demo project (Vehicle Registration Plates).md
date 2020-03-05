# Demo project (Vehicle Registration Plates)

1. Overview:

   -	A function that allows users to search for vehicle registration plates of a province of Vietnam
   -	A function that allows logged-in users to create/edit/delete a province with its vehicle registration plates
   -	A function that allows logged in users to create/edit/delete a user

2. Screen List:

   1. **Login Screen:**

      - Layout

        ![61FA3743-A976-4CAF-B7B3-5910970E6828](https://user-images.githubusercontent.com/33575709/75943179-dd721c00-5ec6-11ea-8deb-be94e2cd2de8.jpeg)

      - Initialization

        - Initialize screen as the layout

      - Items Defination

        | No   | Item Name         | Type     | Required | Init Value | Description                  |
        | ---- | ----------------- | -------- | -------- | ---------- | ---------------------------- |
        | 1    | Email             | Textbox  | yes      | -          | -                            |
        | 2    | Password          | Password | yes      | -          | -                            |
        | 3    | Log in            | Button   | -        | -          | (*) Refer to `Log in` action |
        | 4    | Back to home page | Link     | -        | -          | (**) Refer to `Back` action  |

      - Actions

        - `Log in` action:
          - If user input username/ password match with database then go to `Vehicle Registration Plates List` screen
          - If user login failure then show error message.

   2. **User Management Function:**

      1. **User List Screen:**

         - Layout:

           ![37527D28-090F-4CE8-BE06-B914055CF5A5_1_105_c](https://user-images.githubusercontent.com/33575709/75944291-dc8eb980-5ec9-11ea-9383-e85bf94e3d6c.jpeg)

         - Initialization:

           - Only user logged in system then user can see it. It's not publish out site

         - Items Defination:

           | No   | Item Name   | Type    | Required | Init Value | Description              |
           | ---- | ----------- | ------- | -------- | ---------- | ------------------------ |
           | 1    | User Name   | Textbox | -        | -          | Search condition item    |
           | 2    | Email       | Textbox | -        | -          |                          |
           | 3    | Search      | Button  | -        | -          | Refer to `Search` action |
           | 4    | Add         | Button  | -        | -          | Refer to `Add` action    |
           | 5    | User List   | Table   | -        | -          | -                        |
           | 5.1  | No          | Label   | -        | -          | -                        |
           | 5.2  | User Name   | Label   | -        | -          | -                        |
           | 5.3  | Email       | Label   | -        | -          | -                        |
           | 5.4  | Edit        | Button  | -        | -          | Refer to `Edit` action   |
           | 5.5  | Delete      | Button  | -        | -          | Refer to `Delete` action |
           | 6    | Pagination  | -       | -        | -          | -                        |
           | 6.1  | <<          | Link    | -        | -          | Go to previous page      |
           | 6.2  | Page Number | Link    | -        | -          | Go to specified page     |
           | 6.3  | >>          | Link    | -        | -          | Go to next page          |
           |      |             |         |          |            |                          |

         - Actions:

           - `Search` action:
             - Get all users match with input user name or email value
           - `Add` action:
             - Go to `Add user` screen and allow end user to create new user information.
           - `Edit` action:
             - Go to `Edit user` screen and allow end user to modify some user information such as name, password.
           - `Delete` action:
             - Display a confirm dialog. If user press OK then delete specified user and press Cancel then close dialog.

      2. **Add user screen:**

         - Layout:

           ![99ECC808-C078-44CA-9D42-45053FE407DA_1_105_c](https://user-images.githubusercontent.com/33575709/75946350-70af4f80-5ecf-11ea-9f7a-638cc6c41c95.jpeg)

         - Initialization:

           - Initialize screen as the layout

         - Items Defination:

           | No   | Item Name | Type     | Required | Init Value | Description            |
           | ---- | --------- | -------- | -------- | ---------- | ---------------------- |
           | 1    | Name      | Textbox  | yes      | -          | -                      |
           | 2    | Email     | Textbox  | yes      | -          | -                      |
           | 3    | Password  | Password | yes      | -          | -                      |
           | 4    | Back      | Button   | -        | -          | Refer to `Back` action |
           | 5    | Add       | Button   | -        | -          | Refer to `Add` action  |

         

         - Actions:
           - `Back` action:
             - Go to `User list` screen and keep last state on list screen 
           - `Add` action:
             - If one of item value is invalid then show message error and stay at screen.
             - If all items's value is valid then register new user and go to `User list` screen.

      3. **Edit user screen:**

         - Layout:

           ![BF3041BF-895E-4E1F-921A-EB3EAAB4EF9E_1_105_c](https://user-images.githubusercontent.com/33575709/75946437-b3712780-5ecf-11ea-8217-57f1a8402fc5.jpeg)

         - Initialization:

           - Initialize screen as the layout

         - Items Defination:

           | No   | Item Name | Type     | Required | Init Value | Description              |
           | ---- | --------- | -------- | -------- | ---------- | ------------------------ |
           | 1    | Name      | Textbox  | Yes      | -          | -                        |
           | 2    | Password  | Password | -        | -          | Update new password      |
           | 3    | Back      | Button   | -        | -          | Refer to `Back` action   |
           | 4    | Update    | Button   | -        | -          | Refer to `Update` action |

         - Actions:

           - `Back` action:
             - Go to `User list` screen and keep last state on list screen 
           - `Update` action:
             - If one of item value is invalid then show message error and stay at screen.
             - If all items's value is valid then update user info and go to `User list` screen.

   3. **Vehicle Registration Plate Function:**

      1. **Vehicle Registration Plate List screen :**

         - Layout:

           ![20867D65-B1AF-429C-9961-A4D94D911535](https://user-images.githubusercontent.com/33575709/75946668-4b6f1100-5ed0-11ea-86fe-1f0ddc0fc002.jpeg)

         - Initialization:

           - Initialize screen as the layout

         - Items Defination:

           | No    | Item Name                       | Type    | Required | Init Value | Description                                                  |
           | ----- | ------------------------------- | ------- | -------- | ---------- | ------------------------------------------------------------ |
           | 1     | Province name                   | Textbox | -        | -          | -                                                            |
           | 2     | Search                          | Button  | -        | -          | Refer to `Search` action                                     |
           | 3     | Add                             | Button  | -        | -          | Refer to `Add` action                                        |
           | 4     | Vehicle Registration Plate List | Table   | -        | -          | -                                                            |
           | 4.1   | No                              | Label   | -        | -          | -                                                            |
           | 4.2   | Province Name                   | Label   | -        | -          | -                                                            |
           | 4.3   | Plates                          | Label   | -        | -          | Display value on multiline                                   |
           | 4.4   | Published                       | Label   |          |            | User don't log in then see province's plates has PUBLISHED (1) status |
           | 4.5   | Action                          | -       |          |            |                                                              |
           | 4.5.1 | Edit Icon                       | Link    | -        | -          | - Hide if user don't log in system<br/>- Show if user logged in sytem<br/>- Refer to `Edit` action |
           | 4.5.2 | Delete Icon                     | List    | -        | -          | - Hide if user don't log in system<br/>- Show if user logged in sytem<br/>- Refer to `Delete` action |

         

         - Actions:
           - `Search` action:
             - Display province has name match with input search province name
           - `Add` action:
             - Go to `Add Vehicle Registration Plate` screen.
           - `Edit` action:
             - Go to `Edit Vehicle Registration Plate` screen.
           - `Delete` action:
             - Show confirm dialog.
             - If end user press Ok button then process delete specified province.
             - If end user press Cancel button then close confirm dialog.

      2. **Add Vehicle Registration Plate screen:**

         - Layout:

           ![7B3BD914-5216-4D32-A694-C6B461EC63D5](https://user-images.githubusercontent.com/33575709/75946694-62adfe80-5ed0-11ea-84bf-83c5d5df0697.jpeg)

         - Initialization:

           - Initialize screen as the layout

         - Items Defination:

           | No   | Item Name | Type     | Required | Init value  | Description                                                  |
           | ---- | --------- | -------- | -------- | ----------- | ------------------------------------------------------------ |
           | 1    | Province  | Select   | Yes      | First value | - Province data is got from m_provinces table                |
           | 2    | Plates    | Textarea | Yes      | -           | - Allow user can input multiple plate value<br/>- Maximum plates: 5 |
           | 3    | Published | Checkbox | -        | -           | -                                                            |
           | 4    | Back      | Button   | -        | -           | Refer to `Back` action.                                      |
           | 5    | Add       | Button   | -        | -           | Refer to `Add` action.                                       |

         - Actions:

           - `Back` action:
             - Go to `Vehicle Registration Plate List` screen and keep last state on list screen
           - `Add` action:
             - If one of item value is invalid then show message error and stay at screen.
             - If all items's value is valid then insert new plate info and go to `Vehicle Registration Plate list` screen.

      3. **Edit Vehicle Registration Plate screen:**

         - Layout:

           ![599550C8-F418-4080-BF33-88927E4A2C8E](https://user-images.githubusercontent.com/33575709/75946717-79545580-5ed0-11ea-8d3a-1351b91d9370.jpeg)

         - Initialization:

           - Initialize screen as the layout

         - Items Defination:

           | No   | Item Name | Type     | Required | Init Value | Description                                                |
           | ---- | --------- | -------- | -------- | ---------- | ---------------------------------------------------------- |
           | 1    | Province  | Label    | -        | -          | Display province name                                      |
           | 2    | Plates    | Textarea | -        | -          | - Allow input multiple value<br/>- Maximun input plates: 5 |
           | 3    | Published | Checkbox | -        | -          |                                                            |
           | 4    | Back      | Button   | -        | -          |                                                            |
           | 5    | Update    | Button   | -        | -          |                                                            |

           

         - Actions:

           - `Back` action:
             - Go to `Vehicle Registration Plate List` screen and keep last state on list screen
           - `Update` action:
             - If items's value are not changed then `Update` button will be disabled
             - If there is error then show message and stay at screen
             - If validation is ok then save modified information into database and go to `Vehicle Registration Plate List` screen

3. Database Schema:

   ![5A65C875-C5B8-4111-90AA-00D05F97EAA8](https://user-images.githubusercontent.com/33575709/75956593-cf35f700-5eea-11ea-9e4a-73f789c36eb8.jpeg)





   