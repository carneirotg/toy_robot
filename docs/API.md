## API
  Place the toy robot on the table in position X,Y and facing _NORTH_, _SOUTH_, _EAST_ or _WEST_. The origin (0,0) will be considered to be the SOUTH WEST most corner.
* **URL**
  /robot/
* **Method:**
  `POST`
* **Data Params**
  **Required:**</br>
   `x=[integer][0-5]` </br>
   `y=[integer][0-5]`</br>
   `orientation=[string][NORTH | EAST | SOUTH | WEST]`</br>
* **Success Response:**
  * **Code:** 201 <br />
* **Error Response:**
  * **Code:** 400 BAD_REQUEST <br />
    **Content:** 
    ```json
    {
      "timestamp": "XXX",
      "status": 400,
      "error": "Bad Request",
      "message": "The Y{X} should be >= 0 and <= 5",
      "path": "/robot/"
    }

_MOVE_ will move the toy robot one unit forward in the direction it is currently facing.
_LEFT_ and _RIGHT_ will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
* **URL**
  /robot/position
* **Method:**
  `PUT`
* **Data Params**
  **Required:**
   `action=[string][MOVE | LEFT | RIGHT]`
* **Success Response:**
  * **Code:** 204 <br />
* **Error Response:**
  * **Code:** 404 NOT_FOUND <br />
    **Content:** 
    ```json
    {
      "timestamp": "XXX",
      "status": 404,
      "error": "Bad Request",
      "message": "ROBOT MISSING",
      "path": "/robot/"
    }

_REPORT_ will announce the X,Y and the orientation of the robot at this time. Notice that when Output is called, the robot finishes its movement and a new Robot must be placed to start moving again.
* **URL**
  /robot/report
* **Method:**
  `GET`
* **Success Response:**
  * **Code:** 200 <br />
* **Error Response:**
  * **Code:** 404 NOT_FOUND <br />
    **Content:** 
    ```json
    {
      "timestamp": "XXX",
      "status": 404,
      "error": "Bad Request",
      "message": "ROBOT MISSING",
      "path": "/robot/"
    }
